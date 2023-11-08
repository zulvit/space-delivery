package ru.zulvit.space_delivery.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "mission_participations")
public class MissionParticipation {
    @Id
    private String id;
    private String missionId;
    private String astronautId;
    private String role;
}
