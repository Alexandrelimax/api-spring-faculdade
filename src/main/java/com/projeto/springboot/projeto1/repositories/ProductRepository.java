package com.projeto.springboot.projeto1.repositories;

import com.projeto.springboot.projeto1.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
