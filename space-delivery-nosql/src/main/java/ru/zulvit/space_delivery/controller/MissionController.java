package ru.zulvit.space_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zulvit.space_delivery.model.Mission;
import ru.zulvit.space_delivery.service.MissionService;

import java.util.List;

@RestController
@RequestMapping("/api/missions")
public class MissionController {
    private final MissionService missionService;

    @Autowired
    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping
    public ResponseEntity<List<Mission>> getAllMissions() {
        List<Mission> missions = missionService.getAllMissions();
        return new ResponseEntity<>(missions, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Mission> addMission(@RequestBody Mission mission) {
        Mission created = missionService.addMission(mission);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mission> updateMission(@PathVariable String id, @RequestBody Mission missionDetails) {
        Mission updated = missionService.updateMission(id, missionDetails);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMission(@PathVariable String id) {
        missionService.deleteMission(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mission> getMissionById(@PathVariable(value = "id") String missionId) {
        Mission mission = missionService.getMissionById(missionId);
        return ResponseEntity.ok(mission);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Mission>> getMissionsByStatus(@PathVariable(value = "status") String status) {
        List<Mission> missions = missionService.findByStatus(status);
        return ResponseEntity.ok(missions);
    }
}