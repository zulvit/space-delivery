package ru.zulvit.space_delivery.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "cargoes")
public class Cargo {
    @Id
    private String id;
    @Field
    private String description;
    @Field
    private float weight;
    @Field
    private String purpose;
    @Field
    private Date departureDate;
    @Field
    private Date arrivalDate;
}