package ru.zulvit.space_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zulvit.space_delivery.dto.request.AstronautRequestDto;
import ru.zulvit.space_delivery.dto.response.AstronautResponseDto;
import ru.zulvit.space_delivery.mappers.AstronautMapper;
import ru.zulvit.space_delivery.service.impl.AstronautServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/astronauts")
public class AstronautController {
    private final AstronautServiceImpl astronautService;
    private final AstronautMapper astronautMapper;

    @Autowired
    public AstronautController(AstronautServiceImpl astronautService, AstronautMapper astronautMapper) {
        this.astronautService = astronautService;
        this.astronautMapper = astronautMapper;
    }

    @GetMapping
    public ResponseEntity<List<AstronautResponseDto>> getAllAstronauts() {
        List<AstronautResponseDto> astronauts = astronautService.getAllAstronauts().stream()
                .map(astronautMapper::convertToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(astronauts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AstronautResponseDto> getAstronautById(@PathVariable String id) {
        AstronautResponseDto astronaut = astronautMapper.convertToResponseDto(astronautService.getAstronautById(id));
        return ResponseEntity.ok(astronaut);
    }

    @PostMapping
    public ResponseEntity<AstronautResponseDto> addAstronaut(@RequestBody AstronautRequestDto astronautRequestDto) {
        AstronautResponseDto created = astronautMapper.convertToResponseDto(astronautService.addAstronaut(astronautMapper.convertToEntityFromRequestDto(astronautRequestDto)));
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AstronautResponseDto> updateAstronaut(@PathVariable String id, @RequestBody AstronautRequestDto astronautRequestDto) {
        AstronautResponseDto updated = astronautMapper.convertToResponseDto(astronautService.updateAstronaut(id, astronautMapper.convertToEntityFromRequestDto(astronautRequestDto)));
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAstronaut(@PathVariable String id) {
        astronautService.deleteAstronaut(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count/{nationality}")
    public ResponseEntity<Long> countByNationality(@PathVariable String nationality) {
        return ResponseEntity.ok(astronautService.countByNationality(nationality));
    }
}
