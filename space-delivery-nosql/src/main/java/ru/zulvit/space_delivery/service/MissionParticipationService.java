package ru.zulvit.space_delivery.service;

import ru.zulvit.space_delivery.model.MissionParticipation;

import java.util.List;

public interface MissionParticipationService {
    List<MissionParticipation> getAllParticipation();

    MissionParticipation getParticipationById(String id);

    MissionParticipation addParticipation(MissionParticipation participation);

    MissionParticipation updateParticipation(String id, MissionParticipation participationDetails);

    void deleteParticipation(String id);

    List<MissionParticipation> findByRole(String role);

    List<MissionParticipation> findByAstronautId(String astronautId);
}
