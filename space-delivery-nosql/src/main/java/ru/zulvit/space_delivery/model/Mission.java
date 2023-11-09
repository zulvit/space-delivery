package ru.zulvit.space_delivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "missions")
public class Mission {
    @Id
    private String id;
    private Rocket rocket;
    private Cargo cargo;
    private Date launchDate;
    private Date estimatedArrivalDate;
    private Date actualArrivalDate;
    private String status;
    private List<MissionParticipation> missionParticipations;
}

