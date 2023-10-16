package ru.zulvit.space_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zulvit.space_delivery.dto.request.RocketRequestDto;
import ru.zulvit.space_delivery.dto.response.RocketResponseDto;
import ru.zulvit.space_delivery.mappers.RocketMapper;
import ru.zulvit.space_delivery.model.Rocket;
import ru.zulvit.space_delivery.service.RocketService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rockets")
public class RocketController {

    private final RocketService rocketService;
    private final RocketMapper rocketMapper;

    @Autowired
    public RocketController(RocketService rocketService, RocketMapper rocketMapper) {
        this.rocketService = rocketService;
        this.rocketMapper = rocketMapper;
    }

    @GetMapping
    public ResponseEntity<List<RocketResponseDto>> getAllRockets() {
        List<RocketResponseDto> rocketResponseDtoList = rocketService.getAllRockets().stream()
                .map(rocketMapper::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(rocketResponseDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RocketResponseDto> getRocketById(@PathVariable Long id) {
        RocketResponseDto rocketResponseDto = rocketMapper.convertToResponseDto(rocketService.getRocketById(id));
        return ResponseEntity.ok(rocketResponseDto);
    }

    @PostMapping
    public ResponseEntity<RocketResponseDto> addRocket(@RequestBody RocketRequestDto rocketRequestDto) {
        Rocket created = rocketService.addRocket(rocketMapper.convertToEntityFromRequestDto(rocketRequestDto));
        return ResponseEntity.ok(rocketMapper.convertToResponseDto(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RocketResponseDto> updateRocket(@PathVariable Long id, @RequestBody RocketRequestDto rocketRequestDto) {
        Rocket updated = rocketService.updateRocket(id, rocketMapper.convertToEntityFromRequestDto(rocketRequestDto));
        return ResponseEntity.ok(rocketMapper.convertToResponseDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRocket(@PathVariable Long id) {
        rocketService.deleteRocket(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/manufacturer/{manufacturer}")
    public ResponseEntity<List<RocketResponseDto>> findByManufacturer(@PathVariable String manufacturer) {
        List<RocketResponseDto> rockets = rocketService.findByManufacturer(manufacturer).stream()
                .map(rocketMapper::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(rockets);
    }

    @GetMapping("/load/{load}")
    public ResponseEntity<List<RocketResponseDto>> findByMaxLoadGreaterThan(@PathVariable float load) {
        List<RocketResponseDto> rockets = rocketService.findByMaxLoadGreaterThan(load).stream()
                .map(rocketMapper::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(rockets);
    }
}