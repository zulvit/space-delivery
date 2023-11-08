package ru.zulvit.space_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zulvit.space_delivery.dto.request.CargoRequestDto;
import ru.zulvit.space_delivery.dto.response.CargoResponseDto;
import ru.zulvit.space_delivery.mappers.CargoMapper;
import ru.zulvit.space_delivery.service.CargoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cargoes")
public class CargoController {
    private final CargoService cargoService;
    private final CargoMapper cargoMapper;

    @Autowired
    public CargoController(CargoService cargoService, CargoMapper cargoMapper) {
        this.cargoService = cargoService;
        this.cargoMapper = cargoMapper;
    }

    @GetMapping
    public ResponseEntity<List<CargoResponseDto>> getAllCargoes() {
        List<CargoResponseDto> cargoes = cargoService.getAllCargoes().stream()
                .map(cargoMapper::convertToResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(cargoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoResponseDto> getCargoById(@PathVariable long id) {
        CargoResponseDto cargo = cargoMapper.convertToResponseDto(cargoService.getCargoById(id));
        return new ResponseEntity<>(cargo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CargoResponseDto> addCargo(@RequestBody CargoRequestDto cargoRequestDto) {
        CargoResponseDto newCargo = cargoMapper.convertToResponseDto(cargoService.addCargo(cargoMapper.convertToEntityFromRequestDto(cargoRequestDto)));
        return new ResponseEntity<>(newCargo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoResponseDto> updateCargo(@PathVariable long id, @RequestBody CargoRequestDto cargoDetailsDto) {
        CargoResponseDto updatedCargo = cargoMapper.convertToResponseDto(cargoService.updateCargo(id, cargoMapper.convertToEntityFromRequestDto(cargoDetailsDto)));
        return new ResponseEntity<>(updatedCargo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCargo(@PathVariable long id) {
        cargoService.deleteCargo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/weight/{weight}")
    public ResponseEntity<List<CargoResponseDto>> findByWeightGreaterThan(@PathVariable float weight) {
        List<CargoResponseDto> cargos = cargoService.findByWeightGreaterThan(weight).stream()
                .map(cargoMapper::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cargos);
    }
}
