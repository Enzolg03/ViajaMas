package com.viajamas.app_viajamas.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "jurisdiccion")
public class Jurisdiccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idjurisdiccion;
    private String nomjurisdiccion;
    @ManyToOne
    @JoinColumn(name="idpais")
    private Pais pais;
}
