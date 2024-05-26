package com.example.demo.dto;

import com.example.demo.domain.FoodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodRegisterDto {

    private String name;
    private Integer amount;
    private FoodType foodType;
}
