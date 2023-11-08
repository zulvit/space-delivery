package ru.zulvit.space_delivery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    private String description;
    private float weight;
    private String purpose;
    private Date departureDate;
    private Date arrivalDate;
}
