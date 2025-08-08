package com.example.demo.repository;

import com.example.demo.model.ActiveOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveOrderRepository extends JpaRepository<ActiveOrder, Long> {}
