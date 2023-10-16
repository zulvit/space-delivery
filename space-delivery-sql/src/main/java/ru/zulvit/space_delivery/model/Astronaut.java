package ru.zulvit.space_delivery.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "astronauts")
public class Astronaut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String nationality;
    private Date birthDate;
    private int missionsParticipated;

    @OneToMany(mappedBy = "astronaut", cascade = CascadeType.REMOVE)
    private Set<MissionParticipation> missionParticipation;
}