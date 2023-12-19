package com.IndustrialesComunes.HabiTech.Controllers.request;

import com.IndustrialesComunes.HabiTech.Models.EEUnitType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUnidadExtraDTO {

    private EEUnitType type;

    @Min(0)
    private int m2;

    @Min(0)
    private Long unidadID;
}
