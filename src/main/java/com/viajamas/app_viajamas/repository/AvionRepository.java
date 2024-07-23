package com.viajamas.app_viajamas.repository;

import com.viajamas.app_viajamas.model.bd.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionRepository extends JpaRepository<Avion,Integer> {
}
