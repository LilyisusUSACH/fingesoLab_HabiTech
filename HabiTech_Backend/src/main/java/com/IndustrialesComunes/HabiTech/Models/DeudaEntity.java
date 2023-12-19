package com.IndustrialesComunes.HabiTech.Models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "deuda")
public class DeudaEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private Boolean pagado;

    private float value;

    private int cuota;

    private LocalDate fechaInicio;

    private LocalDate fechaTermino;

    @ManyToOne
    @JoinColumn(name = "gastoComunAsociado")
    public GastoComunEntity gastoComunAsociado;

    @ManyToOne
    @JoinColumn(name = "residente_id")
    @JsonIgnore
    private UserEntity residente;

    @ManyToOne
    @JoinColumn(name = "ordenPago")
    @JsonIgnore
    private OrdenPagoEntity ordenPago;

    public double calcularInteresMorosidad(){
        return getValue()*1.02;
    }

    @JsonGetter("residente_id")
    private Long residenteID(){
        return getResidente().getId();
    }
}
