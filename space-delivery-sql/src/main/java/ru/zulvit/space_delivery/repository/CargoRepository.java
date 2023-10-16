package ru.zulvit.space_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.space_delivery.model.Cargo;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    List<Cargo> findByWeightGreaterThan(float weight);
}
