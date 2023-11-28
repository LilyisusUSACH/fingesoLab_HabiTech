package com.IndustrialesComunes.HabiTech.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "gastoComun")
public class GastoComun {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Column(name = "id")
    private long id;

    @Getter @Setter
    @Column(name = "descripcion")
    private String description;

    @Getter @Setter
    @Column(name = "detalle")
    private String detail;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Building edificio;

    @ManyToMany
    @JoinTable(
            name = "gasto_deuda",
            joinColumns = @JoinColumn(name = "gastoComun_id"),
            inverseJoinColumns = @JoinColumn(name = "deuda_id")
    )
    public List<Deuda> deudasGeneradas;

    private void generarDeudas(){};

}
