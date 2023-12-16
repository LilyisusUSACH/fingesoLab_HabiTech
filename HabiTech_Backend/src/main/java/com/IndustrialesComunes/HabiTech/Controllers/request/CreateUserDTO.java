package com.IndustrialesComunes.HabiTech.Controllers.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    @Email
    @NotBlank
    private String email;

    @NonNull
    @Min(0)
    @Max(999999999)
    private Integer rut;

    @NotBlank
    private String password;
}
