package ru.zulvit.space_delivery.service.impl;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zulvit.space_delivery.exceptions.ResourceNotFoundException;
import ru.zulvit.space_delivery.model.Cargo;
import ru.zulvit.space_delivery.repository.CargoRepository;
import ru.zulvit.space_delivery.service.CargoService;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> getAllCargoes() {
        return cargoRepository.findAll();
    }

    public Cargo getCargoById(long id) {
        return cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo not found with id " + id));
    }

    public Cargo addCargo(@NotNull Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public Cargo updateCargo(long id, @NotNull Cargo cargoDetails) {
        Cargo cargo = getCargoById(id);
        cargo.setDescription(cargoDetails.getDescription());
        cargo.setWeight(cargoDetails.getWeight());
        cargo.setDescription(cargoDetails.getDescription());
        return cargoRepository.save(cargo);
    }

    public void deleteCargo(long id) {
        Cargo cargo = getCargoById(id);
        cargoRepository.delete(cargo);
    }

    @Override
    public List<Cargo> findByWeightGreaterThan(float weight) {
        return cargoRepository.findByWeightGreaterThan(weight);
    }
}
