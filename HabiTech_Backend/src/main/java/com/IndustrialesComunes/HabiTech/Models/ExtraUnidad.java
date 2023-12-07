package com.IndustrialesComunes.HabiTech.Models;

import com.IndustrialesComunes.HabiTech.Models.Comunnity;
import com.IndustrialesComunes.HabiTech.Models.Unidad;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "unidadExtra")
public class ExtraUnidad {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Column(name = "id")
    private long id;

    @Getter @Setter
    @Column(name = "metrosCuadradosExtra")
    private int m2e;

    @ManyToOne
    @JoinColumn(name = "unidad_id")
    private Unidad unidad;

}
