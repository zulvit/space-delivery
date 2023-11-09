package ru.zulvit.space_delivery.init;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.zulvit.space_delivery.model.*;
import ru.zulvit.space_delivery.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Component
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner {
    private final AstronautRepository astronautRepository;
    private final CargoRepository cargoRepository;
    private final MissionRepository missionRepository;
    private final MissionParticipationRepository missionParticipationRepository;
    private final RocketRepository rocketRepository;

    @Autowired
    public DatabaseSeeder(AstronautRepository astronautRepository,
                          CargoRepository cargoRepository,
                          MissionRepository missionRepository,
                          MissionParticipationRepository missionParticipationRepository,
                          RocketRepository rocketRepository) {
        this.astronautRepository = astronautRepository;
        this.cargoRepository = cargoRepository;
        this.missionRepository = missionRepository;
        this.missionParticipationRepository = missionParticipationRepository;
        this.rocketRepository = rocketRepository;
    }

    @Override
    public void run(String... args) {
        Faker faker = new Faker(Locale.UK);

        // Очистка предыдущих данных
        astronautRepository.deleteAll();
        cargoRepository.deleteAll();
        missionRepository.deleteAll();
        missionParticipationRepository.deleteAll();
        rocketRepository.deleteAll();

        // Создание ракет
        List<Rocket> rockets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Rocket rocket = new Rocket(
                    null,
                    faker.space().star(),
                    faker.company().name(),
                    ThreadLocalRandom.current().nextFloat() * (1000 - 100) + 100,
                    ThreadLocalRandom.current().nextFloat() * (20000 - 10000) + 10000);
            rockets.add(rocketRepository.save(rocket));
        }

        // Создание астронавтов и миссий
        List<Astronaut> astronauts = new ArrayList<>();
        List<Mission> missions = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Astronaut astronaut = new Astronaut(
                    null,
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.nation().nationality(),
                    faker.date().birthday(),
                    faker.number().numberBetween(0, 10));
            astronauts.add(astronautRepository.save(astronaut));

            Cargo cargo = new Cargo(
                    null,
                    faker.lorem().sentence(),
                    ThreadLocalRandom.current().nextFloat() * (1000 - 10) + 10,
                    "Research",
                    faker.date().future(365, TimeUnit.DAYS),
                    faker.date().future(365 * 2, TimeUnit.DAYS));
            cargo = cargoRepository.save(cargo);

            Mission mission = new Mission(
                    null,
                    rockets.get(faker.number().numberBetween(0, rockets.size())),
                    cargo,
                    faker.date().future(365, TimeUnit.DAYS),
                    faker.date().future(365 * 2, TimeUnit.DAYS),
                    null,
                    "Scheduled",
                    new ArrayList<>());
            missions.add(missionRepository.save(mission));
        }

        // Создание участий в миссиях
        for (Mission mission : missions) {
            for (int i = 0; i < faker.number().numberBetween(1, 6); i++) {
                MissionParticipation participation = new MissionParticipation(
                        null,
                        mission.getId(),
                        astronauts.get(faker.number().numberBetween(0, astronauts.size())).getId(),
                        faker.job().title());
                missionParticipationRepository.save(participation);
            }
        }
    }
}
