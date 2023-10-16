package ru.zulvit.space_delivery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.space_delivery.model.Mission;

@Repository
public interface MissionRepository extends MongoRepository<Mission, String> {
}
