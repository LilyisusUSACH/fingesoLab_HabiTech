package com.IndustrialesComunes.HabiTech.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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

    private String name;

    @NotBlank
    private String ubication;

    private int nOfUnits = 0;

    @Min(0)
    private int m2 = 0;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private CommunityEntity community;

    @OneToMany(mappedBy = "edificio")
    @JsonIgnore
    private List<UnidadEntity> unidades;

    @OneToMany(mappedBy = "edificio")
    private List<GastoComunEntity> gastosComunes;

    @JsonGetter("community_id")
    public long community(){
        return this.community.getId();
    }
}
