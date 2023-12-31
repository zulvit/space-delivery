package ru.zulvit.space_delivery.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "rockets")

public class Rocket {
    @Id
    private String id;
    private String name;
    private String manufacturer;
    private float maxLoad;
    private float speed;
}

