package com.IndustrialesComunes.HabiTech.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "condominioOrEdificio")
public class Building{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Column(name = "id")
    private long id;

    @Getter @Setter
    @Column(name = "ubicacion")
    private String ubication;

    @Getter @Setter
    @Column(name = "cantidadUnidades")
    private int nOfUnits;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @OneToMany(mappedBy = "edificio")
    private List<Unidad> unidades;

    @OneToMany(mappedBy = "edificio")
    private List<GastoComun> gastosComunes;

}
