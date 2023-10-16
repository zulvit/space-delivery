package ru.zulvit.space_delivery.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zulvit.space_delivery.exceptions.ResourceNotFoundException;
import ru.zulvit.space_delivery.model.MissionParticipation;
import ru.zulvit.space_delivery.repository.MissionParticipationRepository;
import ru.zulvit.space_delivery.service.MissionParticipationService;

import java.util.List;

@Service
public class MissionParticipationServiceImpl implements MissionParticipationService {
    private final MissionParticipationRepository missionParticipationRepository;

    @Autowired
    public MissionParticipationServiceImpl(MissionParticipationRepository missionParticipationRepository) {
        this.missionParticipationRepository = missionParticipationRepository;
    }

    @Override
    public List<MissionParticipation> getAllParticipation() {
        return missionParticipationRepository.findAll();
    }

    @Override
    public MissionParticipation getParticipationById(long id) {
        return missionParticipationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Participation not found with id: " + id));
    }

    @Override
    public MissionParticipation addParticipation(MissionParticipation participation) {
        return missionParticipationRepository.save(participation);
    }

    @Override
    public MissionParticipation updateParticipation(long id, MissionParticipation participationDetails) {
        return missionParticipationRepository.findById(id)
                .map(participation -> {
                    participation.setMission(participationDetails.getMission());
                    participation.setAstronaut(participationDetails.getAstronaut());
                    participation.setRole(participationDetails.getRole());
                    return missionParticipationRepository.save(participation);
                }).orElseThrow(() -> new ResourceNotFoundException("Participation not found with id: " + id));
    }

    @Override
    public void deleteParticipation(long id) {
        if (missionParticipationRepository.existsById(id)) {
            missionParticipationRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Participation not found with id: " + id);
        }
    }

    @Override
    public List<MissionParticipation> findByRole(String role) {
        return missionParticipationRepository.findByRole(role);
    }

    @Override
    public List<MissionParticipation> findByAstronautId(int astronautId) {
        return missionParticipationRepository.findByAstronautId(astronautId);
    }
}
