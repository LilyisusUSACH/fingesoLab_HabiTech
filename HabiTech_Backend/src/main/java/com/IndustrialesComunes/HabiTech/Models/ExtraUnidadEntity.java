package com.IndustrialesComunes.HabiTech.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "unidadExtra")
public class ExtraUnidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int m2e;


    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private UnidadEntity unidad;


}
