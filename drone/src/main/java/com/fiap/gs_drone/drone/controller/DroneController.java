package com.fiap.gs_drone.drone.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.gs_drone.drone.dto.DroneRequestCreate;
import com.fiap.gs_drone.drone.dto.DroneRequestUpdate;
import com.fiap.gs_drone.drone.dto.ResponseDrone;
import com.fiap.gs_drone.drone.service.DroneService;

@RestController
@RequestMapping("drone")
public class DroneController {

    @Autowired
    public DroneService droneService;

    @GetMapping
    public ResponseEntity<List<ResponseDrone>> findAll() {
        return ResponseEntity.ok(droneService
                .findAll()
                .stream()
                .map(drone -> new ResponseDrone().toDto(drone))
                .collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDrone> findById(@PathVariable Long id) {
        return droneService.findById(id)
                .map(drone -> ResponseEntity.ok(new ResponseDrone().toDto(drone)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResponseDrone> create(@RequestBody DroneRequestCreate dto) {

        return ResponseEntity.status(201).body(
                new ResponseDrone().toDto(
                        droneService.save(dto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseDrone> update(
            @PathVariable Long id,
            @RequestBody DroneRequestUpdate dto) {

        return droneService.update(id, dto)
                .map(drone -> ResponseEntity.ok(new ResponseDrone().toDto(drone)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = droneService.deleteById(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
