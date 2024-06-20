package com.viajamas.app_viajamas.repository;

import com.viajamas.app_viajamas.model.bd.Jurisdiccion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JurisdiccionRepository extends JpaRepository <Jurisdiccion, Integer>{
    @Transactional
    @Modifying
    @Query(value = "UPDATE jurisdiccion SET descripcion=:descripcion, idpais=:idpais where idjurisdiccion=:idjurisdiccion",
            nativeQuery = true)
    void actualizarJurisdiccion(@Param("descripcion") String descripcion,
                           @Param("idpais") Integer idpais,
                            @Param("idjurisdiccion") Integer idjurisdiccion);
}
