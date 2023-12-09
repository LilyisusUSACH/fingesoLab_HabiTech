package com.IndustrialesComunes.HabiTech.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
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
    //@JsonBackReference
    private Community community;

    @OneToMany(mappedBy = "edificio")
    private List<Unidad> unidades;

    @OneToMany(mappedBy = "edificio")
    private List<GastoComun> gastosComunes;

    public Building(String ubication, int nOfUnits, Community community) {
        this.ubication = ubication;
        this.nOfUnits = nOfUnits;
        this.community = community;
        community.setNOfBuilds(community.getNOfBuilds() + 1);
        community.addEdificio(this);
    }

    public Building() {

    }

    @JsonGetter("community_id")
    public long community(){
        return this.community.getId();
    }
}
