package ru.zulvit.space_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.zulvit.space_delivery.model.Astronaut;
import ru.zulvit.space_delivery.service.impl.AstronautServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/astronauts")
public class AstronautController {
    private final AstronautServiceImpl astronautService;

    @Autowired
    public AstronautController(AstronautServiceImpl astronautService) {
        this.astronautService = astronautService;
    }

    @GetMapping
    public ResponseEntity<List<Astronaut>> getAllAstronauts() {
        List<Astronaut> astronauts = astronautService.getAllAstronauts();
        return ResponseEntity.ok(astronauts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Astronaut> getAstronautById(@PathVariable String id) {
        Astronaut astronaut = astronautService.getAstronautById(id);
        return ResponseEntity.ok(astronaut);
    }

    @PostMapping
    public ResponseEntity<Astronaut> addAstronaut(@RequestBody Astronaut astronaut) {
        Astronaut created = astronautService.addAstronaut(astronaut);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Astronaut> updateAstronaut(@PathVariable String id, @RequestBody Astronaut astronaut) {
        Astronaut updated = astronautService.updateAstronaut(id, astronaut);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAstronaut(@PathVariable String id) {
        astronautService.deleteAstronaut(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count/{nationality}")
    public ResponseEntity<Long> countByNationality(@PathVariable String nationality) {
        long count = astronautService.countByNationality(nationality);
        return ResponseEntity.ok(count);
    }
}
