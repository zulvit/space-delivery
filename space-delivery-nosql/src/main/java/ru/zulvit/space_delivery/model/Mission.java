package ru.zulvit.space_delivery.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Mission {
    @Id
    private long id;
    @Field
    private long rocketId;
    @Field
    private long cargoId;
    @Field
    private Date launchDate;
    @Field
    private Date estimatedArrivalDate;
    @Field
    private Date actualArrivalDate;
    @Field
    private String status;
    @Field
    private List<String> astronautsParticipated;
}
