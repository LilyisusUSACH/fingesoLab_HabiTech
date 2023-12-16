package com.IndustrialesComunes.HabiTech.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "condominioOrEdificio")
public class BuildingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ubication;

    private int nOfUnits;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private CommunityEntity community;

    @OneToMany(mappedBy = "edificio")
    private List<UnidadEntity> unidades;

    @OneToMany(mappedBy = "edificio")
    private List<GastoComunEntity> gastosComunes;

    @JsonGetter("community_id")
    public long community(){
        return this.community.getId();
    }
}
