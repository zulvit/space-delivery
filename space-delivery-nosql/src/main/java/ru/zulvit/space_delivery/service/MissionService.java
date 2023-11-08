package ru.zulvit.space_delivery.service;

import ru.zulvit.space_delivery.model.Mission;

import java.util.Date;
import java.util.List;


public interface MissionService {
    List<Mission> getAllMissions();

    Mission getMissionById(String id);

    Mission addMission(Mission mission);

    Mission updateMission(String id, Mission missionDetails);

    void deleteMission(String id);

    List<Mission> findByStatus(String status);

    List<Mission> findByLaunchDateAfter(Date date);
}
