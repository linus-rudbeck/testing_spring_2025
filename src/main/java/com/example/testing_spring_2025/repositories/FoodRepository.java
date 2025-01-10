package com.example.testing_spring_2025.repositories;

import com.example.testing_spring_2025.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends JpaRepository<Food, Long> { }
