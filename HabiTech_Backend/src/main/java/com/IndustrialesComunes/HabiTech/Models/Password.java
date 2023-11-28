package com.IndustrialesComunes.HabiTech.Models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "password")
@ToString
@EqualsAndHashCode
public class Password{

    @Id
    @OneToOne
    @MapsId
    @JoinColumn(name="usuario_id")
    private User usuario;

    @Getter
    @Column(name = "password")
    private String password;

    public Boolean samePassword(String pass){

        return true; //this.password.equals(pass);
    }
    public void setPassword(String pass) {
       // this.password = pass;
    }
}
