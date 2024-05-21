package com.example.demo.dto;

import com.example.demo.domain.FoodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodRegisterDto {

    private String name;
    private Integer amount;
    private FoodType foodType;
}
