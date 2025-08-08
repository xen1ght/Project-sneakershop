package com.example.demo.controller;

import com.example.demo.model.ActiveOrder;
import com.example.demo.model.Sneaker;
import com.example.demo.model.User;
import com.example.demo.repository.ActiveOrderRepository;
import com.example.demo.repository.SneakerRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private ActiveOrderRepository activeOrderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SneakerRepository sneakerRepository;

    // Получить все заказы
    @GetMapping("/all")
    public List<ActiveOrder> getAllOrders() {
        return activeOrderRepository.findAll();
    }

    // Создание нового заказа
    @PostMapping("/add")
    public ActiveOrder addOrder(@RequestBody ActiveOrder orderRequest) {
        User user = userRepository.findByUsername(orderRequest.getClientName())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));


        if (user.getId() == null) {
            throw new RuntimeException("ID пользователя отсутствует");
        }

        ActiveOrder order = new ActiveOrder();
        order.setClientName(user.getUsername());
        order.setIdClient(user.getId());
        order.setNameAllsneakers(orderRequest.getNameAllsneakers());
        order.setStatus("Заказ поступил");

        return activeOrderRepository.save(order);
    }

    // Обновление статуса заказа и обновление склада
    @PutMapping("/update-status/{id}")
    public ActiveOrder updateStatus(@PathVariable Long id, @RequestParam String status) {
        ActiveOrder order = activeOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setStatus(status);
        ActiveOrder updatedOrder = activeOrderRepository.save(order);

        if (status.equals("Заказ отправлен") || status.equals("Завершён")) {
            Sneaker sneaker = sneakerRepository.findBySneakersName(order.getNameAllsneakers())
                    .orElseThrow(() -> new RuntimeException("Sneaker not found"));

            int newCount = sneaker.getCountOfSneakers() - 1;
            sneaker.setCountOfSneakers(Math.max(0, newCount));
            sneakerRepository.save(sneaker);
        }

        return updatedOrder;
    }
}
