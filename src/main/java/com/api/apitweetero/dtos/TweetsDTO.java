package com.api.apitweetero.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TweetsDTO(
        @NotNull
        @Size(min = 1, max = 30)
        String username,
        @NotNull
        @Size(min = 1,max = 255)
        String tweet

) {
}
