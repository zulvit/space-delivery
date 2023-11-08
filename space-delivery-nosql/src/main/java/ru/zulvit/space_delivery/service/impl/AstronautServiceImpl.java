package ru.zulvit.space_delivery.service.impl;

import lombok.extern.log4j.Log4j2;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zulvit.space_delivery.exceptions.ResourceNotFoundException;
import ru.zulvit.space_delivery.model.Astronaut;
import ru.zulvit.space_delivery.repository.AstronautRepository;
import ru.zulvit.space_delivery.service.AstronautService;

import java.util.List;

@Service
@Log4j2
public class AstronautServiceImpl implements AstronautService {
    private final AstronautRepository astronautRepository;

    @Autowired
    public AstronautServiceImpl(AstronautRepository astronautRepository) {
        this.astronautRepository = astronautRepository;
    }

    @Override
    public List<Astronaut> getAllAstronauts() {
        return astronautRepository.findAll();
    }

    @Override
    public Astronaut getAstronautById(String id) {
        return astronautRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Astronaut not found with id " + id));
    }

    @Override
    public Astronaut addAstronaut(@NotNull Astronaut astronaut) {
        astronaut.setId(ObjectId.get().toHexString());
        return astronautRepository.save(astronaut);
    }

    @Override
    public Astronaut updateAstronaut(String id, @NotNull Astronaut astronautDetails) {
        Astronaut astronaut = getAstronautById(id);
        astronaut.setFirstName(astronautDetails.getFirstName());
        astronaut.setLastName(astronautDetails.getLastName());
        astronaut.setNationality(astronautDetails.getNationality());
        astronaut.setBirthDate(astronautDetails.getBirthDate());
        astronaut.setMissionsParticipated(astronautDetails.getMissionsParticipated());
        return astronautRepository.save(astronaut);
    }

    @Override
    public void deleteAstronaut(String id) {
        Astronaut astronaut = getAstronautById(id);
        astronautRepository.delete(astronaut);
    }

    @Override
    public Long countByNationality(String nationality) {
        return astronautRepository.countByNationality(nationality);
    }

    @Override
    public List<Astronaut> findByMissionsParticipatedGreaterThan(int missionCount) {
        return astronautRepository.findByMissionsParticipatedGreaterThan(missionCount);
    }
}
