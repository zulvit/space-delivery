package ru.zulvit.space_delivery.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cargoes")
public class Cargo {
    @Id
    private String id;
    private String description;
    private float weight;
    private String purpose;
    private Date departureDate;
    private Date arrivalDate;
}

