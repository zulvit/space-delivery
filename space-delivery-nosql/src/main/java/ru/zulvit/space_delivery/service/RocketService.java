package ru.zulvit.space_delivery.service;

import ru.zulvit.space_delivery.model.Rocket;

import java.util.List;

public interface RocketService {
    List<Rocket> getAllRockets();

    Rocket getRocketById(long id);

    Rocket addRocket(Rocket rocket);

    Rocket updateRocket(long id, Rocket rocketDetails);

    void deleteRocket(long id);

    List<Rocket> findByManufacturer(String manufacturer);

    List<Rocket> findByMaxLoadGreaterThan(float load);
}

