package com.viajamas.app_viajamas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.viajamas.app_viajamas.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    //Select * from rol where nomrol = '' and idrol = 0
    Rol findByNomrol(String nomrol);
}
