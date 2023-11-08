package ru.zulvit.space_delivery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import ru.zulvit.space_delivery.model.Astronaut;

import java.util.List;

@Repository
public interface AstronautRepository extends MongoRepository<Astronaut, String> {
    Long countByNationality(String nationality);

    List<Astronaut> findByMissionsParticipatedGreaterThan(int missionCount);
}
