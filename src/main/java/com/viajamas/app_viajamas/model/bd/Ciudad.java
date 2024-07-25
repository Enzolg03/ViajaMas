package com.viajamas.app_viajamas.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idciudad;
    private String nomciudad;
    @ManyToOne
    @JoinColumn(name="idjurisdiccion")
    private Jurisdiccion jurisdiccion;
}
