package com.IndustrialesComunes.HabiTech.Models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
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

    private int value;

    private Time fechaInicio;

    private Time fechaTermino;

   @ManyToMany(mappedBy = "deudasGeneradas")
    public List<GastoComunEntity> gastosComunesAsociados;

    @ManyToOne
    @JoinColumn(name = "residente_id")
    private UserEntity residente;
    public double calcularInteresMorosidad(){
        return getValue()*1.02;
    }

    public void generarOrdenPago(){}
}
