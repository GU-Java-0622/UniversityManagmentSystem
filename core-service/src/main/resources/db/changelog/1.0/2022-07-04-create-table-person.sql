CREATE TABLE persons
(
    id         BIGINT NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE default current_timestamp,
    update_at  TIMESTAMP WITHOUT TIME ZONE default current_timestamp,
    CONSTRAINT pk_persons PRIMARY KEY (id)
);

insert into persons(id)
values (1), -- ADMIN
       (2), --Student
       (3) --Teacher