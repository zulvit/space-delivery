package ru.zulvit.space_delivery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.space_delivery.model.MissionParticipation;

import java.util.List;

@Repository
public interface MissionParticipationRepository extends MongoRepository<MissionParticipation, String> {
    List<MissionParticipation> findByRole(String role);

    List<MissionParticipation> findByAstronautId(String astronautId);
}
