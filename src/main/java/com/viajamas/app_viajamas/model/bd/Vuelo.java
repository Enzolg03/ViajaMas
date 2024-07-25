package com.viajamas.app_viajamas.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idvuelo;
    private String numerovuelo;

    @ManyToOne
    @JoinColumn(name="idaerolinea")
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name="idavion")
    private Avion avion;

    @ManyToOne
    @JoinColumn(name="id_aeropuerto_origen")
    private Aeropuerto aeropuerto_origen;

    @ManyToOne
    @JoinColumn(name="id_aeropuerto_destino")
    private Aeropuerto aeropuerto_destino;

    private String fechasalida;
    private String fechallegada;
    private Integer duracion;
}
