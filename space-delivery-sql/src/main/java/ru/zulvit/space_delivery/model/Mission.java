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
@Table(name = "missions")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "rocket_id")
    private Rocket rocket;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    private Date launchDate;
    private Date estimatedArrivalDate;
    private Date actualArrivalDate;
    private String status;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.REMOVE)
    private Set<MissionParticipation> missionParticipation;
}