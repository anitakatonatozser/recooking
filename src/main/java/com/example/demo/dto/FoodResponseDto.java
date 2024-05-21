package com.example.demo.dto;

import com.example.demo.domain.Food;
import com.example.demo.domain.FoodType;
import lombok.Data;

@Data
public class FoodResponseDto {

    private String name;
    private Integer amount;
    private FoodType foodType;

    public FoodResponseDto(Food food) {
        this.name = food.getName();
        this.amount = food.getAmount();
        this.foodType = food.getFoodType();
    }
}
