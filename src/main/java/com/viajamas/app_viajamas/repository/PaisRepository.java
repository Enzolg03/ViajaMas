package com.viajamas.app_viajamas.repository;

import com.viajamas.app_viajamas.model.bd.Pais;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Integer> {
    //@Transactional
    //@Modifying
    //@Query(value = "UPDATE pais SET descripcion=:descripcion where idpais=:idpais",
            //nativeQuery = true)
    //void actualizarPais(@Param("descripcion") String descripcion);
}
