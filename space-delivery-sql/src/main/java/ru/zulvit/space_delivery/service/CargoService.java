package ru.zulvit.space_delivery.service;

import ru.zulvit.space_delivery.model.Cargo;

import java.util.List;

public interface CargoService {
    List<Cargo> getAllCargoes();

    Cargo getCargoById(long id);

    Cargo addCargo(Cargo cargo);

    Cargo updateCargo(long id, Cargo cargoDetails);

    void deleteCargo(long id);

    List<Cargo> findByWeightGreaterThan(float weight);
}
