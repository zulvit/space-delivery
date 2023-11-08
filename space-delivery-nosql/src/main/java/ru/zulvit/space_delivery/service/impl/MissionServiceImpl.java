package ru.zulvit.space_delivery.service.impl;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zulvit.space_delivery.exceptions.ResourceNotFoundException;
import ru.zulvit.space_delivery.model.Mission;
import ru.zulvit.space_delivery.repository.MissionRepository;
import ru.zulvit.space_delivery.service.MissionService;

import java.util.Date;
import java.util.List;

@Service
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;

    @Autowired
    public MissionServiceImpl(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    @Override
    public Mission getMissionById(String id) {
        return missionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mission not found with id " + id));
    }

    @Override
    public Mission addMission(@NotNull Mission mission) {
        // Assume that the Mission object already contains an embedded Rocket and Cargo object
        return missionRepository.save(mission);
    }

    @Override
    public Mission updateMission(String id, @NotNull Mission missionDetails) {
        return missionRepository.findById(id)
                .map(mission -> {
                    mission.setLaunchDate(missionDetails.getLaunchDate());
                    mission.setEstimatedArrivalDate(missionDetails.getEstimatedArrivalDate());
                    mission.setActualArrivalDate(missionDetails.getActualArrivalDate());
                    mission.setStatus(missionDetails.getStatus());

                    return missionRepository.save(mission);
                }).orElseThrow(() -> new ResourceNotFoundException("Mission not found with id " + id));
    }

    @Override
    public void deleteMission(String id) {
        Mission mission = getMissionById(id);
        missionRepository.delete(mission);
    }

    @Override
    public List<Mission> findByStatus(String status) {
        return missionRepository.findByStatus(status);
    }

    @Override
    public List<Mission> findByLaunchDateAfter(Date date) {
        return missionRepository.findByLaunchDateAfter(date);
    }
}
