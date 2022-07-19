CREATE TABLE learning_programmes
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title         VARCHAR(255),
    status        VARCHAR(255),
    created_at     TIMESTAMP WITHOUT TIME ZONE,
    deprecated_at TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_learning_programmes PRIMARY KEY (id)
);

create table learning_programmes_lessons
(
    learning_programme_id BIGINT NOT NULL
        constraint fk_learning_programmes_lessons_on_learning_programmes references learning_programmes(id),
    lesson_id             BIGINT not null
        constraint fk_learning_programmes_lessons_on_lessons references lessonTemplates(id)
);

insert into learning_programmes(id, title, status, created_at, deprecated_at)
values (1, 'Java1', 'ACTIVE', '2022-07-13 16:01:22.000000', '2022-07-19 16:01:58.000000'),
       (2, 'Java2', 'ACTIVE', '2022-07-13 16:02:15.000000', '2022-07-20 16:02:17.000000'),
       (3, 'Java3', 'ACTIVE', '2022-07-13 16:02:34.000000', '2022-07-23 16:02:37.000000');

insert into learning_programmes_lessons(learning_programme_id, lesson_id)
VALUES (1,1),
       (2,2),
       (3,3),
       (1,4),
       (2,5);

