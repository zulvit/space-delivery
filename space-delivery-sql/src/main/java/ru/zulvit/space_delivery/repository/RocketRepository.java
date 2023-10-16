package ru.zulvit.space_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.space_delivery.model.Rocket;

import java.util.List;

@Repository
public interface RocketRepository extends JpaRepository<Rocket, Long> {
    List<Rocket> findByManufacturer(String manufacturer);

    List<Rocket> findByMaxLoadGreaterThan(float load);
}
