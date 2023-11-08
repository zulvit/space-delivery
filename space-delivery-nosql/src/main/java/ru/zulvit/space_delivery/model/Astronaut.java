package ru.zulvit.space_delivery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Document(collection = "astronauts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Astronaut {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String nationality;
    private Date birthDate;
    private int missionsParticipated;

    private List<MissionParticipation> missionParticipations;
}
