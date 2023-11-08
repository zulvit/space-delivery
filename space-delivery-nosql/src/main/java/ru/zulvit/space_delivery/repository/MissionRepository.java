package ru.zulvit.space_delivery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.space_delivery.model.Mission;

import java.util.Date;
import java.util.List;

@Repository
public interface MissionRepository extends MongoRepository<Mission, Long> {
    List<Mission> findByStatus(String status);

    List<Mission> findByLaunchDateAfter(Date date);
}
