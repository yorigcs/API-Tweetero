package com.api.apitweetero.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsersDTO(
        @NotNull
        @Size(max = 30)
        String username,
        @NotNull
        @Size(max = 30)
        String avatar
) {
}
