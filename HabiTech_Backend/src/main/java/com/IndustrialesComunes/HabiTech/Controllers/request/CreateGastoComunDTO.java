package com.IndustrialesComunes.HabiTech.Controllers.request;

import com.IndustrialesComunes.HabiTech.Models.EGastoComunType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGastoComunDTO {

    private EGastoComunType type;

    @NotBlank
    private String description;

    @Min(0)
    private int total;

    @Min(0)
    private int cuotas;

    @Min(0)
    private Long edificioID;

}
