package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @PostMapping("/login")
    public User loginUser(@RequestBody User loginRequest) {
        return userRepository
                .findByUsernameAndMail(loginRequest.getUsername(), loginRequest.getMail())
                .orElseThrow(() -> new RuntimeException("Неверное имя пользователя или email"));
    }


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public User updateOrders(@PathVariable Long id,
                             @RequestParam int numberOfOrders,
                             @RequestParam int sumOrders) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setNumberOfOrders(numberOfOrders);
        user.setSumOrders(sumOrders);
        return userRepository.save(user);
    }
}
