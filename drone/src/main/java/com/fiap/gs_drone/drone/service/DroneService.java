package com.fiap.gs_drone.drone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.gs_drone.drone.dto.DroneRequestCreate;
import com.fiap.gs_drone.drone.dto.DroneRequestUpdate;
import com.fiap.gs_drone.drone.model.Drone;
import com.fiap.gs_drone.drone.repository.DroneRepository;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    public Drone save(DroneRequestCreate dto) {

        Drone drone = new Drone();
        drone.setCodigoDrone(dto.getCodigoDrone());
        drone.setStatus(dto.getStatus());
        drone.setObservacao(dto.getObservacao());

        return droneRepository.save(drone);
    }

    public Optional<Drone> update(Long id,
            DroneRequestUpdate dto) {
        return droneRepository.findById(id)
                .map(drone -> {
                    drone.setCodigoDrone(dto.getCodigoDrone());
                    drone.setStatus(dto.getStatus());
                    drone.setObservacao(dto.getObservacao());
                    return droneRepository.save(drone);
                });

    }

    public List<Drone> findAll() {
        return droneRepository.findAll();
    }

    public Optional<Drone> findById(Long id) {
        return droneRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        if (droneRepository.existsById(id)) {
            droneRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
