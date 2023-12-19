package com.IndustrialesComunes.HabiTech.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "gastoComun")
public class GastoComunEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private EGastoComunType type;

    private String description;

    private int total;

    private int cuotas;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    @JsonIgnore
    private BuildingEntity edificio;
/*

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = DeudaEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "gasto_deuda",
            joinColumns = @JoinColumn(name = "gastoComun_id"),
            inverseJoinColumns = @JoinColumn(name = "deuda_id")
    )
    public List<DeudaEntity> deudasGeneradas = new ArrayList<>();
    */
    @OneToMany(mappedBy = "gastoComunAsociado")
    @JsonIgnore
    private List<DeudaEntity> deudasGeneradas  = new ArrayList<>();

    //     private void generarDeudas(){};

    @JsonGetter("edificio_id")
    private Long edificioID(){
        return edificio.getId();
    }

}
