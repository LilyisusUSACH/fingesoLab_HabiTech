package com.IndustrialesComunes.HabiTech.Controllers.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUnidadDTO {

    private Long edificioID;

    @NotBlank
    private String name;

    private Long residenteID;

    @NotBlank
    private String ubication;

    @Min(0)
    private int m2soloUnidad;

}
