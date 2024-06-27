package com.viajamas.app_viajamas.repository;

import com.viajamas.app_viajamas.model.bd.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionRepository extends JpaRepository<Avion,Integer> {
    //@Transactional
    //@Modifying
    //@Query(value = "UPDATE Avion SET modelo=:modelo, capacidadpasajeros=:capacidadpasajeros where idavion=:idavion",
    //nativeQuery = true)
    //void actualizarAvion(@Param("modelo") String modelo,
                               // @Param("capacidadpasajeros") Integer capacidadpasajeros,
                             //   @Param("idavion") Integer idavion);
}
