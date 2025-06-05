package com.fiap.gs_drone.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.gs_drone.drone.model.Drone;



@Repository
public interface DroneRepository
        extends JpaRepository<Drone, Long> {

    }

