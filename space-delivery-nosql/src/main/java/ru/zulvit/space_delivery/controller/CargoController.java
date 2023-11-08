package ru.zulvit.space_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zulvit.space_delivery.model.Cargo;
import ru.zulvit.space_delivery.service.CargoService;

import java.util.List;

@RestController
@RequestMapping("/api/cargoes")
public class CargoController {
    private final CargoService cargoService;

    @Autowired
    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> getAllCargoes() {
        List<Cargo> cargoes = cargoService.getAllCargoes();
        return new ResponseEntity<>(cargoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable String id) {
        Cargo cargo = cargoService.getCargoById(id);
        return new ResponseEntity<>(cargo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cargo> addCargo(@RequestBody Cargo cargo) {
        Cargo newCargo = cargoService.addCargo(cargo);
        return new ResponseEntity<>(newCargo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> updateCargo(@PathVariable String id, @RequestBody Cargo cargoDetails) {
        Cargo updatedCargo = cargoService.updateCargo(id, cargoDetails);
        return new ResponseEntity<>(updatedCargo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCargo(@PathVariable String id) {
        cargoService.deleteCargo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/weight/{weight}")
    public ResponseEntity<List<Cargo>> findByWeightGreaterThan(@PathVariable float weight) {
        List<Cargo> cargos = cargoService.findByWeightGreaterThan(weight);
        return ResponseEntity.ok(cargos);
    }
}
