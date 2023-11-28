package com.IndustrialesComunes.HabiTech.Models;

import com.IndustrialesComunes.HabiTech.Models.userTypes.ExtraUnidad;
import com.IndustrialesComunes.HabiTech.Models.userTypes.Residente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "unidad")
public class Unidad{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Column(name = "id")
    private long id;

    @Getter @Setter
    @Column(name = "ubicacion")
    private String ubication;

    @Getter @Setter
    @Column(name = "metrosCuadrados")
    private int m2;

    @Getter @Setter
    @Column(name = "prorrateo")
    private float prorrateo;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Building edificio;

    @ManyToOne
    @JoinColumn(name = "residente_id")
    private Residente residente;

    @OneToMany(mappedBy = "unidad")
    private List<ExtraUnidad> extra;

    private void calcularProrrateo(){
        this.prorrateo = 0;
    }

}
