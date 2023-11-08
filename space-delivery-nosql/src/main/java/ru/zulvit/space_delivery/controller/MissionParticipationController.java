package ru.zulvit.space_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zulvit.space_delivery.model.MissionParticipation;
import ru.zulvit.space_delivery.service.impl.MissionParticipationServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/participations")
public class MissionParticipationController {
    private final MissionParticipationServiceImpl missionParticipationService;

    @Autowired
    public MissionParticipationController(MissionParticipationServiceImpl missionParticipationService) {
        this.missionParticipationService = missionParticipationService;
    }

    @GetMapping
    public ResponseEntity<List<MissionParticipation>> getAllParticipation() {
        List<MissionParticipation> participations = missionParticipationService.getAllParticipation();
        return ResponseEntity.ok(participations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionParticipation> getParticipationById(@PathVariable String id) {
        MissionParticipation participation = missionParticipationService.getParticipationById(id);
        return ResponseEntity.ok(participation);
    }

    @PostMapping
    public ResponseEntity<MissionParticipation> addParticipation(@RequestBody MissionParticipation participation) {
        MissionParticipation created = missionParticipationService.addParticipation(participation);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissionParticipation> updateParticipation(@PathVariable String id, @RequestBody MissionParticipation participationDetails) {
        MissionParticipation updated = missionParticipationService.updateParticipation(id, participationDetails);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParticipation(@PathVariable String id) {
        missionParticipationService.deleteParticipation(id);
        return ResponseEntity.noContent().build();
    }
}