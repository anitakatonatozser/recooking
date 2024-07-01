package com.example.demo.controller;

import com.example.demo.domain.Food;
import com.example.demo.domain.FoodType;
import com.example.demo.dto.FoodRegisterDto;
import com.example.demo.dto.FoodResponseDto;
import com.example.demo.service.DonationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class DonationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DonationService donationService;

    @BeforeEach
    void init(){
        DonationController underTest = new DonationController(donationService);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    void testRegisterFood() throws Exception{
        FoodRegisterDto foodRegisterDto = FoodRegisterDto.builder()
                .name("tomato")
                .amount(1)
                .foodType(FoodType.VEGETABLES).build();
        Food food = new Food();
        food.setName("tomato");
        food.setAmount(1);
        food.setFoodType(FoodType.VEGETABLES);
        when(donationService.registerFood(foodRegisterDto)).thenReturn(new FoodResponseDto(food));



    }

}