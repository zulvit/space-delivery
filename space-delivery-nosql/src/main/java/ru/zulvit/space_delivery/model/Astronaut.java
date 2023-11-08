package ru.zulvit.space_delivery.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "astronauts")
public class Astronaut {
    @Id
    private String id;
    @Field
    private String firstName;
    @Field
    private String lastName;
    @Field
    private String nationality;
    @Field
    private Date birthDate;
    @Field
    private int missionsParticipated;
    @Field
    private List<MissionParticipation> missionParticipation;
}
