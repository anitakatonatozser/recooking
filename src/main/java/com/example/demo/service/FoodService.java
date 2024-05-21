package com.example.demo.service;

import com.example.demo.dto.FoodRegisterDto;
import com.example.demo.dto.FoodResponseDto;

public interface FoodService {

    FoodResponseDto registerFood(FoodRegisterDto foodRegisterDto);
}
