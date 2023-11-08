package ru.zulvit.space_delivery.service;

import ru.zulvit.space_delivery.model.Cargo;

import java.util.List;

public interface CargoService {
    List<Cargo> getAllCargoes();

    Cargo getCargoById(String id);

    Cargo addCargo(Cargo cargo);

    Cargo updateCargo(String id, Cargo cargoDetails);

    void deleteCargo(String id);

    List<Cargo> findByWeightGreaterThan(float weight);
}
