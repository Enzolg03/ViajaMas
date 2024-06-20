package com.viajamas.app_viajamas.repository;

import com.viajamas.app_viajamas.model.bd.Ciudad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad,Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE ciudad SET descripcion=:descripcion, idjurisdiccion=:idjurisdiccion where idciudad=:idciudad",
            nativeQuery = true)
    void actualizarCiudad(@Param("descripcion") String descripcion,
                           @Param("idjurisdiccion") Integer idjurisdiccion,
                            @Param("idciudad")Integer idciudad);
}
