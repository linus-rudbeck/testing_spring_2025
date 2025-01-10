package com.example.testing_spring_2025;

import com.example.testing_spring_2025.controllers.FoodController;
import com.example.testing_spring_2025.models.Food;
import com.example.testing_spring_2025.repositories.FoodRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FoodController.class)
public class FoodControllerTest {

    @MockBean
    private FoodRepository repository;


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getFoods_ShouldReturnListOfFoods() throws Exception {

        var foods = List.of(
                new Food("Test food 1", 1),
                new Food("Test food 2", 2)
        );

        when(repository.findAll()).thenReturn(foods);

        mockMvc.perform(get("/api/foods"))
                .andExpect(status().isOk()) // Status: 200
                .andExpect(jsonPath("$", hasSize(2)));
    }


    @Test
    public void seedCars_ShouldReturnList() throws Exception {

        mockMvc.perform(post("/api/seed"))
                .andExpect(status().isOk()) // Status: 200
                .andExpect(jsonPath("$", hasSize(2)));
    }

}
