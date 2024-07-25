package com.viajamas.app_viajamas.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idaeropuerto;
    private String nomaeropuerto;
    @ManyToOne
    @JoinColumn(name="idciudad")
    private Ciudad ciudad;
    @ManyToOne
    @JoinColumn(name="idjurisdiccion")
    private Jurisdiccion jurisdiccion;
    @ManyToOne
    @JoinColumn(name="idpais")
    private Pais pais;
}
