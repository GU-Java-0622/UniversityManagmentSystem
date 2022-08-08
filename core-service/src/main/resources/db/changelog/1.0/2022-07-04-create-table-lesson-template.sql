CREATE TABLE lessons_template
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    theme              VARCHAR(255),
    duration           TIME WITHOUT TIME ZONE,
    training_manual    VARCHAR(255),
    homework           VARCHAR(255),
    course_template_id BIGINT,
    created_at         TIMESTAMP WITHOUT TIME ZONE default current_timestamp,
    update_at          TIMESTAMP WITHOUT TIME ZONE default current_timestamp,
    CONSTRAINT pk_lessons_template PRIMARY KEY (id)
);

ALTER TABLE lessons_template
    ADD CONSTRAINT FK_LESSONS_TEMPLATE_ON_COURSE_TEMPLATE FOREIGN KEY (course_template_id) REFERENCES course_template (id);

insert into lessons_template ( theme, duration, course_template_id)
values  ('Java_Lesson1', '00:45:00', 1),
        ('Java_Lesson2', '00:40:00', 1),
        ('Java_Lesson3', '00:43:00', 1),
        ('Java_Lesson4', '00:38:00', 1),
        ('Java_Lesson5', '00:35:00', 1),
        ('Python_Lesson1', '00:41:00', 2),
        ('Python_Lesson2', '00:44:00', 2),
        ('Python_Lesson3', '00:50:00', 2),
        ('Python_Lesson4', '00:25:00', 2),
        ('Python_Lesson5', '00:27:00', 2);