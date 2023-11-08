package ru.zulvit.space_delivery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.space_delivery.model.Rocket;

import java.util.List;

@Repository
public interface RocketRepository extends MongoRepository<Rocket, String> {
    List<Rocket> findByManufacturer(String manufacturer);

    List<Rocket> findByMaxLoadGreaterThan(float load);
}
