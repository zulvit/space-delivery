package ru.zulvit.space_delivery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Document(collection = "missions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mission {
    @Id
    private String id;
    private Cargo cargo;
    private Date launchDate;
    private Date estimatedArrivalDate;
    private Date actualArrivalDate;
    private String status;

    private List<MissionParticipation> missionParticipations;
}
