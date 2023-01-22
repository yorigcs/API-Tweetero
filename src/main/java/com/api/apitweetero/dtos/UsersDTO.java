package com.api.apitweetero.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record UsersDTO(
        @NotBlank
        @Max(30)
        String username,
        @NotBlank
        String avatar
) {
}
