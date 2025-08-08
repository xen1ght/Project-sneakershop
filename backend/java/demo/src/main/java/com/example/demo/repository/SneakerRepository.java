package com.example.demo.repository;

import com.example.demo.model.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SneakerRepository extends JpaRepository<Sneaker, Long> {
    Optional<Sneaker> findBySneakersName(String sneakersName);
}
