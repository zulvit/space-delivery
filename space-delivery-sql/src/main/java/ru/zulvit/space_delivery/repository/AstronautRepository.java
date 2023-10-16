package ru.zulvit.space_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.space_delivery.model.Astronaut;

import java.util.List;

@Repository
public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
    Long countByNationality(String nationality);

    List<Astronaut> findByMissionsParticipatedGreaterThan(int missionCount);
}