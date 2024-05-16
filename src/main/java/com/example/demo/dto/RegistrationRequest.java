package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    @Email(message = "invalid E-mail format")
    @Min(3)
    private String email;
    @NotBlank(message = "must not be blank")
    @Min(3)
    private String userName;
    @NotBlank(message = "must not be blank")
    @Min(3)
    private String password;
}