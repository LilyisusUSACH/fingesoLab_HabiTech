package com.IndustrialesComunes.HabiTech.Controllers.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBuildingDTO{

    @NotBlank
    private String ubication;

    @NotBlank
    private String name;

    @Min(0)
    private Long id_com;
}
