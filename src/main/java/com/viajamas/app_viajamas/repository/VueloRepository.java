package com.viajamas.app_viajamas.repository;

import com.viajamas.app_viajamas.model.bd.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository <Vuelo,Integer> {
}
