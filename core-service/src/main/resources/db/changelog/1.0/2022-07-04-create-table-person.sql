CREATE TABLE persons
(
    id BIGINT NOT NULL,
    CONSTRAINT pk_persons PRIMARY KEY (id)
);

insert into persons(id)
values (1), -- ADMIN
       (2), --Student
       (3) --Teacher