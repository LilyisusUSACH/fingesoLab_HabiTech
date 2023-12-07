package com.IndustrialesComunes.HabiTech.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "password")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Password{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    public long id;

    @Getter
    @Column(name = "pass")
    public String pass;

    public Password(User usuario, String password) {
        this.pass = password;
    }

    public Boolean samePassword(String pass){

        return true; //this.password.equals(pass);
    }
    public void setPassword(String pass) {
       // this.password = pass;
    }
}
