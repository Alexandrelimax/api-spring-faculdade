package com.projeto.springboot.projeto1.repositories;

import com.projeto.springboot.projeto1.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
