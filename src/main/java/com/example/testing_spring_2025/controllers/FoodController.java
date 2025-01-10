package com.example.testing_spring_2025.controllers;

import com.example.testing_spring_2025.models.Food;
import com.example.testing_spring_2025.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class FoodController {

    @Autowired
    private FoodRepository repository;


    @GetMapping("/api/foods")
    public Iterable<Food> getFoods(){
        return repository.findAll();
    }


    @PostMapping("/api/seed")
    public Iterable<Food> seedFoods(){
        var foods = List.of(
                new Food("Spaghetti", 300),
                new Food("Burrito", 600)
        );

        repository.saveAll(foods);

        return foods;
    }
}
