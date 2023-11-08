package ru.zulvit.space_delivery.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "rockets")
public class Rocket {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String manufacturer;
    @Field
    private float maxLoad;
    @Field
    private float speed;
}