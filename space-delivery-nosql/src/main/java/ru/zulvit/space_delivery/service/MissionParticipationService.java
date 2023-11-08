package ru.zulvit.space_delivery.service;

import ru.zulvit.space_delivery.model.MissionParticipation;

import java.util.List;

public interface MissionParticipationService {
    List<MissionParticipation> getAllParticipation();

    MissionParticipation getParticipationById(long id);

    MissionParticipation addParticipation(MissionParticipation participation);

    MissionParticipation updateParticipation(long id, MissionParticipation participationDetails);

    void deleteParticipation(long id);

    List<MissionParticipation> findByRole(String role);

    List<MissionParticipation> findByAstronautId(int astronautId);
}
