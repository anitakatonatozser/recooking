package com.example.demo.service.impl;

import com.example.demo.domain.Food;
import com.example.demo.dto.FoodRegisterDto;
import com.example.demo.dto.FoodResponseDto;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public FoodResponseDto registerFood(FoodRegisterDto foodRegisterDto) {
        Food food = Food.builder().name(foodRegisterDto.getName()).amount(foodRegisterDto.getAmount())
                .foodType(foodRegisterDto.getFoodType()).build();
        foodRepository.save(food);
        return new FoodResponseDto(food);
    }
}
