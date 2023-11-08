package ru.zulvit.space_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zulvit.space_delivery.model.Rocket;
import ru.zulvit.space_delivery.service.RocketService;

import java.util.List;

@RestController
@RequestMapping("/api/rockets")
public class RocketController {

    private final RocketService rocketService;

    @Autowired
    public RocketController(RocketService rocketService) {
        this.rocketService = rocketService;
    }

    @GetMapping
    public ResponseEntity<List<Rocket>> getAllRockets() {
        List<Rocket> rockets = rocketService.getAllRockets();
        return ResponseEntity.ok(rockets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rocket> getRocketById(@PathVariable String id) {
        Rocket rocket = rocketService.getRocketById(id);
        return ResponseEntity.ok(rocket);
    }

    @PostMapping
    public ResponseEntity<Rocket> addRocket(@RequestBody Rocket rocket) {
        Rocket created = rocketService.addRocket(rocket);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rocket> updateRocket(@PathVariable String id, @RequestBody Rocket rocket) {
        Rocket updated = rocketService.updateRocket(id, rocket);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRocket(@PathVariable String id) {
        rocketService.deleteRocket(id);
        return ResponseEntity.noContent().build();
    }
}
