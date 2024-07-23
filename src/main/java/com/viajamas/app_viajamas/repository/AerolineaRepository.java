package com.viajamas.app_viajamas.repository;

import com.viajamas.app_viajamas.model.bd.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Integer> {
}
