package com.example.testing.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserLittleDto {
    @NotEmpty
    public String name;
    @NotEmpty
    public String email;
}
