package ru.zulvit.space_delivery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zulvit.space_delivery.model.MissionParticipation;

import java.util.List;

@Repository
public interface MissionParticipationRepository extends JpaRepository<MissionParticipation, Long> {
    List<MissionParticipation> findByRole(String role);

    List<MissionParticipation> findByAstronautId(int astronautId);
}
