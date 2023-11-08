package ru.zulvit.space_delivery.service.impl;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zulvit.space_delivery.exceptions.ResourceNotFoundException;
import ru.zulvit.space_delivery.model.Rocket;
import ru.zulvit.space_delivery.repository.RocketRepository;
import ru.zulvit.space_delivery.service.RocketService;

import java.util.List;

@Service
public class RocketServiceImpl implements RocketService {
    private final RocketRepository rocketRepository;

    @Autowired
    public RocketServiceImpl(RocketRepository rocketRepository) {
        this.rocketRepository = rocketRepository;
    }

    public List<Rocket> getAllRockets() {
        return rocketRepository.findAll();
    }

    public Rocket getRocketById(long id) {
        return rocketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rocket not found with id " + id));
    }

    public Rocket addRocket(@NotNull Rocket rocket) {
        return rocketRepository.save(rocket);
    }

    public Rocket updateRocket(long id, @NotNull Rocket rocketDetails) {
        Rocket rocket = getRocketById(id);
        rocket.setName(rocketDetails.getName());
        rocket.setManufacturer(rocketDetails.getManufacturer());
        rocket.setMaxLoad(rocketDetails.getMaxLoad());
        return rocketRepository.save(rocket);
    }

    public void deleteRocket(long id) {
        Rocket rocket = getRocketById(id);
        rocketRepository.delete(rocket);
    }

    @Override
    public List<Rocket> findByManufacturer(String manufacturer) {
        return rocketRepository.findByManufacturer(manufacturer);
    }

    @Override
    public List<Rocket> findByMaxLoadGreaterThan(float load) {
        return rocketRepository.findByMaxLoadGreaterThan(load);
    }
}
