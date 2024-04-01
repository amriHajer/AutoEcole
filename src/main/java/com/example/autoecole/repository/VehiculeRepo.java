package com.example.autoecole.repository;

import com.example.autoecole.entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VehiculeRepo extends JpaRepository <Vehicule, Integer> {
}
