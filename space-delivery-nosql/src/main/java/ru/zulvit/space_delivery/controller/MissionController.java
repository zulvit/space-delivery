package ru.zulvit.space_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zulvit.space_delivery.dto.request.MissionRequestDto;
import ru.zulvit.space_delivery.dto.response.MissionResponseDto;
import ru.zulvit.space_delivery.mappers.MissionMapper;
import ru.zulvit.space_delivery.model.Mission;
import ru.zulvit.space_delivery.service.CargoService;
import ru.zulvit.space_delivery.service.MissionService;
import ru.zulvit.space_delivery.service.RocketService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/missions")
public class MissionController {
    private final MissionService missionService;
    private final RocketService rocketService;
    private final CargoService cargoService;
    private final MissionMapper missionMapper;

    @Autowired
    public MissionController(MissionService missionService, RocketService rocketService, CargoService cargoService, MissionMapper missionMapper) {
        this.missionService = missionService;
        this.rocketService = rocketService;
        this.cargoService = cargoService;
        this.missionMapper = missionMapper;
    }

    @GetMapping
    public ResponseEntity<List<MissionResponseDto>> getAllMissions() {
        List<MissionResponseDto> missions = missionService.getAllMissions().stream()
                .map(missionMapper::convertToResponseDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(missions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MissionResponseDto> addMission(@RequestBody MissionRequestDto missionRequestDto) {
        var rocket = rocketService.getRocketById(missionRequestDto.getRocketId());
        var cargo = cargoService.getCargoById(missionRequestDto.getCargoId());

        Mission mission = new Mission();
        mission.setRocketId(rocket.getId());
        mission.setCargoId(cargo.getId());
        mission.setLaunchDate(missionRequestDto.getLaunchdate());
        mission.setEstimatedArrivalDate(missionRequestDto.getEstimatedArrivalDate());
        mission.setStatus(missionRequestDto.getStatus());

        Mission created = missionService.addMission(mission);
        MissionResponseDto missionResponseDto = missionMapper.convertToResponseDto(created);
        return ResponseEntity.ok(missionResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissionResponseDto> updateMission(@PathVariable Long id, @RequestBody MissionRequestDto missionDetailsDto) {
        Mission missionDetails = missionMapper.convertToEntityFromRequestDto(missionDetailsDto);
        Mission updated = missionService.updateMission(id, missionDetails);
        return ResponseEntity.ok(missionMapper.convertToResponseDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMission(@PathVariable Long id) {
        missionService.deleteMission(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mission> getMissionById(@PathVariable(value = "id") Long missionId) {
        Mission mission = missionService.getMissionById(missionId);
        return ResponseEntity.ok().body(mission);
    }

    @GetMapping("/status/{status}")
    public List<Mission> getMissionsByStatus(@PathVariable(value = "status") String status) {
        return missionService.findByStatus(status);
    }
}