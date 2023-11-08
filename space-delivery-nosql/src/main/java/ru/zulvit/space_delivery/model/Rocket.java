package ru.zulvit.space_delivery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "rockets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rocket {
    @Id
    private String id;
    private String name;
    private String manufacturer;
    private float maxLoad;
    private float speed;
}
