package com.viajamas.app_viajamas.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "aerolinea")
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idaerolinea;
    private String nomaerolinea;
    @ManyToOne
    @JoinColumn(name="idpais")
    private Pais pais;
}
