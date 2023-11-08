package ru.zulvit.space_delivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "astronauts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Astronaut {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String nationality;
    private Date birthDate;
    private int missionsParticipated;
}
