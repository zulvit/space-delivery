package ru.zulvit.space_delivery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.space_delivery.model.Cargo;

import java.util.List;

@Repository
public interface CargoRepository extends MongoRepository<Cargo, String> {
    List<Cargo> findByWeightGreaterThan(float weight);
}
