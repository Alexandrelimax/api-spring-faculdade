package com.projeto.springboot.projeto1.repositories;

import com.projeto.springboot.projeto1.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
