package ru.zulvit.space_delivery.service;

import ru.zulvit.space_delivery.model.Astronaut;

import java.util.List;

public interface AstronautService {
    List<Astronaut> getAllAstronauts();

    Astronaut getAstronautById(long id);

    Astronaut addAstronaut(Astronaut astronaut);

    Astronaut updateAstronaut(long id, Astronaut astronautDetails);

    void deleteAstronaut(long id);

    Long countByNationality(String nationality);

    List<Astronaut> findByMissionsParticipatedGreaterThan(int missionCount);
}

