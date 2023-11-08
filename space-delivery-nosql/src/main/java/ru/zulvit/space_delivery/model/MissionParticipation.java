package ru.zulvit.space_delivery.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "mission_participations")
public class MissionParticipation {
    @Id
    private String id;
    @Field
    private long missionId;
    @Field
    private long astronautId;
    @Field
    private String role;
}
