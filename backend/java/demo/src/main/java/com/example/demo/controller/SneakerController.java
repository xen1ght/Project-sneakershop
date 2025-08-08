package com.example.demo.controller;

import com.example.demo.model.Sneaker;
import com.example.demo.repository.SneakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sneakers")
@CrossOrigin(origins = "*")
public class SneakerController {

    @Autowired
    private SneakerRepository sneakerRepository;

    @PostMapping("/add")
    public Sneaker addSneaker(@RequestBody Sneaker sneaker) {
        return sneakerRepository.save(sneaker);
    }
}
