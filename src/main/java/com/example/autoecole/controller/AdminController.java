package com.example.autoecole.controller;

import com.example.autoecole.dto.ReqRes;
import com.example.autoecole.entity.Vehicule;
import com.example.autoecole.repository.VehiculeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private VehiculeRepo vehiculeRepo;

    @GetMapping("/public/vehicule")
    public ResponseEntity<Object> getAllProducts(){
        return ResponseEntity.ok(vehiculeRepo.findAll());
    }

    @PostMapping("/admin/saveVehicule")
    public ResponseEntity<Object> saveVehicule(@RequestBody Vehicule vehiculeRequest) {
        try {
            Vehicule savedVehicule = vehiculeRepo.save(vehiculeRequest);
            return ResponseEntity.ok(savedVehicule);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while saving vehicule: " + e.getMessage());
        }
    }

}



