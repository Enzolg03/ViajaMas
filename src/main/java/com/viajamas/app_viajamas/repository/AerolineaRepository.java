package com.viajamas.app_viajamas.repository;

import com.viajamas.app_viajamas.model.bd.Aerolinea;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Integer> {
    /**@Transactional
    @Modifying
    @Query(value = "UPDATE aerolinea SET nombre=:nombre, idpais=:idpais where  idaerolinea=: idaerolinea",
            nativeQuery = true)
    void actualizarAerolinea(@Param("nombre") String nombre,
                                @Param("idpais") Integer idpais,
                                @Param("idaerolinea") Integer idaerolinea);**/
}
