package com.IndustrialesComunes.HabiTech.Models;

import com.IndustrialesComunes.HabiTech.Models.userTypes.Residente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "deuda")
public class Deuda {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Column(name = "id")
    private long id;

    @Getter @Setter
    @Column(name = "pagado")
    private Boolean pagado;

    @Getter @Setter
    @Column(name = "valor")
    private int value;

    @Getter @Setter
    @Column(name = "fechaInicio")
    private Time fechaInicio;

    @Getter @Setter
    @Column(name = "fechaTermino")
    private Time fechaTermino;

    @ManyToMany(mappedBy = "deudasGeneradas")
    public List<GastoComun> gastosComunesAsociados;

    @ManyToOne
    @JoinColumn(name = "residente_id")
    private Residente residente;

    public double calcularInteresMorosidad(){
        return getValue()*1.02;
    }

    public void generarOrdenPago(){}

}
