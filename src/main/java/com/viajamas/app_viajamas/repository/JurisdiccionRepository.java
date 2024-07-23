package com.viajamas.app_viajamas.repository;

import com.viajamas.app_viajamas.model.bd.Jurisdiccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurisdiccionRepository extends JpaRepository <Jurisdiccion, Integer>{
}
