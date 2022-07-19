CREATE TABLE persons
(
    user_id    BIGINT NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    surname    VARCHAR(255),
    CONSTRAINT pk_persons PRIMARY KEY (user_id)
);