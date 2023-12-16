package com.IndustrialesComunes.HabiTech.Models;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "mensajes")
public class MessageEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="sender_id")
    @JsonIgnore
    private UserEntity sender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="receiver_id")
    @JsonIgnore
    private UserEntity receiver;

    @NotBlank
    private String message;

    @JsonGetter
    private String sender(){
        return sender.getUsername();
    }

    @JsonGetter
    private String receiver(){
        return receiver.getUsername();
    }
}
