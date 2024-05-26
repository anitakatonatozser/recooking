package com.example.demo.controller;

import com.example.demo.dto.FoodRegisterDto;
import com.example.demo.dto.FoodResponseDto;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.FoodService;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public FoodResponseDto registerFood(@Valid @RequestBody FoodRegisterDto foodRegisterDto){
        log.info("New food is registered.");
        return foodService.registerFood(foodRegisterDto);
    }
}
