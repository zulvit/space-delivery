package ru.zulvit.space_delivery.service;

import ru.zulvit.space_delivery.model.Mission;

import java.util.Date;
import java.util.List;


public interface MissionService {
    List<Mission> getAllMissions();

    Mission getMissionById(long id);

    Mission addMission(Mission mission);

    Mission updateMission(long id, Mission missionDetails);

    void deleteMission(long id);

    List<Mission> findByStatus(String status);

    List<Mission> findByLaunchDateAfter(Date date);
}
