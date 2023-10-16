CREATE TABLE rockets
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(255),
    manufacturer VARCHAR(255),
    max_load     FLOAT,
    speed        FLOAT
);

CREATE TABLE cargoes
(
    id             SERIAL PRIMARY KEY,
    description    VARCHAR(255),
    weight         FLOAT,
    purpose        VARCHAR(255),
    departure_date TIMESTAMP,
    arrival_date   TIMESTAMP
);

CREATE TABLE astronauts
(
    id                    SERIAL PRIMARY KEY,
    first_name            VARCHAR(255),
    last_name             VARCHAR(255),
    nationality           VARCHAR(255),
    birth_date            TIMESTAMP,
    missions_participated INT
);

CREATE TABLE missions
(
    id                     SERIAL PRIMARY KEY,
    rocket_id              INT,
    cargo_id               INT,
    launch_date            TIMESTAMP,
    estimated_arrival_date TIMESTAMP,
    actual_arrival_date    TIMESTAMP,
    status                 VARCHAR(255),
    FOREIGN KEY (rocket_id) REFERENCES rockets (id),
    FOREIGN KEY (cargo_id) REFERENCES cargoes (id)
);

CREATE TABLE mission_participation
(
    id           SERIAL PRIMARY KEY,
    mission_id   INT,
    astronaut_id INT,
    role         VARCHAR(255),
    FOREIGN KEY (mission_id) REFERENCES missions (id),
    FOREIGN KEY (astronaut_id) REFERENCES astronauts (id)
);