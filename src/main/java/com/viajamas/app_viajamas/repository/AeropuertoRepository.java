package com.viajamas.app_viajamas.repository;

import com.viajamas.app_viajamas.model.bd.Aeropuerto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Integer> {
    /*@Transactional
    @Modifying
    @Query(value = "UPDATE aeropuerto SET nombre=:nombre, idciudad=:idciudad, idjurisdiccion=:idjurisdiccion, idpais=:idpais where  idaeropuerto=: idaeropuerto",
            nativeQuery = true)
    void actualizarAeropuerto(@Param("nombre") String nombre,
                             @Param("idciudad") Integer idciudad,
                             @Param("idjurisdiccion") Integer idjurisdiccion,
                             @Param("idpais") Integer idpais,
                             @Param("idaeropuerto") Integer idaeropuerto);*/
}
