package com.IndustrialesComunes.HabiTech.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "fondos")
public class FondosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameFondo;

    @ManyToOne
    @JoinColumn(name = "community_id")
    @JsonIgnore
    private CommunityEntity community;


/*    @Override
    public String toString() {
        return "Fondos{" +
                "nameFondo='" + nameFondo + '\'' +
                ", value=" + value +
                '}';
    }*/

}
