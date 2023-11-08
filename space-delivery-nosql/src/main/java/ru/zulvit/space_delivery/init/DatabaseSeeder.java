package ru.zulvit.space_delivery.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.zulvit.space_delivery.model.Astronaut;
import ru.zulvit.space_delivery.model.Mission;
import ru.zulvit.space_delivery.repository.AstronautRepository;
import ru.zulvit.space_delivery.repository.MissionRepository;

import java.util.Date;

@Component
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner {
    private final AstronautRepository astronautRepository;
    private final MissionRepository missionRepository;

    @Autowired
    public DatabaseSeeder(AstronautRepository astronautRepository, MissionRepository missionRepository) {
        this.astronautRepository = astronautRepository;
        this.missionRepository = missionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Astronaut astronaut = new Astronaut();
        astronaut.setBirthDate(new Date(1231231));
        astronaut.setNationality("EN");
        astronaut.setFirstName("Migel");
        astronaut.setLastName("Testik");
        astronaut.setMissionsParticipated(1);
        astronautRepository.save(astronaut);

        Mission mission = new Mission();
        mission.setStatus("OK");
        mission.setLaunchDate(new Date(123123));
        missionRepository.save(mission);
    }
}
