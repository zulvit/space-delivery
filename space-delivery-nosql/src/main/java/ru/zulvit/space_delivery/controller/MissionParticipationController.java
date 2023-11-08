package ru.zulvit.space_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zulvit.space_delivery.dto.request.MissionParticipationRequestDto;
import ru.zulvit.space_delivery.dto.response.MissionParticipationResponseDto;
import ru.zulvit.space_delivery.mappers.MissionParticipationMapper;
import ru.zulvit.space_delivery.model.MissionParticipation;
import ru.zulvit.space_delivery.service.impl.MissionParticipationServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/participations")
public class MissionParticipationController {
    private final MissionParticipationServiceImpl missionParticipationService;
    private final MissionParticipationMapper mapper;

    @Autowired
    public MissionParticipationController(MissionParticipationServiceImpl missionParticipationService, MissionParticipationMapper mapper) {
        this.missionParticipationService = missionParticipationService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<MissionParticipationResponseDto>> getAllParticipation() {
        List<MissionParticipationResponseDto> participationDtoList = missionParticipationService.getAllParticipation().stream()
                .map(mapper::entityToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(participationDtoList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MissionParticipationResponseDto> getParticipationById(@PathVariable String id) {
        MissionParticipationResponseDto participationDto = mapper.entityToResponseDto(missionParticipationService.getParticipationById(id));
        return ResponseEntity.ok(participationDto);
    }

    @PostMapping
    public ResponseEntity<MissionParticipationResponseDto> addParticipation(@RequestBody MissionParticipationRequestDto participationDto) {
        MissionParticipation created = missionParticipationService.addParticipation(mapper.requestDtoToEntity(participationDto));
        return ResponseEntity.ok(mapper.entityToResponseDto(created));
    }


    @PutMapping("/{id}")
    public ResponseEntity<MissionParticipationResponseDto> updateParticipation(@PathVariable String id, @RequestBody MissionParticipationRequestDto participationDto) {
        MissionParticipation updated = missionParticipationService.updateParticipation(id, mapper.requestDtoToEntity(participationDto));
        return ResponseEntity.ok(mapper.entityToResponseDto(updated));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParticipation(@PathVariable String id) {
        missionParticipationService.deleteParticipation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<MissionParticipationResponseDto>> findByRole(@PathVariable String role) {
        List<MissionParticipationResponseDto> participations = missionParticipationService.findByRole(role).stream()
                .map(mapper::entityToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(participations);
    }

    @GetMapping("/astronaut/{astronautId}")
    public ResponseEntity<List<MissionParticipationResponseDto>> findByAstronautId(@PathVariable String astronautId) {
        List<MissionParticipationResponseDto> participations = missionParticipationService.findByAstronautId(astronautId).stream()
                .map(mapper::entityToResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(participations);
    }
}