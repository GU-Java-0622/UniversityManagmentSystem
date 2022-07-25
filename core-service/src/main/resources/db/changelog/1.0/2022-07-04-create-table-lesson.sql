CREATE TABLE active_lesson
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    lesson_template_id BIGINT,
    learning_programm  BIGINT,
    started_at         TIMESTAMP WITHOUT TIME ZONE,
    cource_id          BIGINT,
    finished_at        TIMESTAMP WITHOUT TIME ZONE,
    training_manual    VARCHAR(255),
    homework           VARCHAR(255),
    is_finished        BOOLEAN,
    CONSTRAINT pk_active_lesson PRIMARY KEY (id)
);

ALTER TABLE active_lesson
    ADD CONSTRAINT FK_ACTIVE_LESSON_ON_COURCE FOREIGN KEY (cource_id) REFERENCES active_stream (id);

ALTER TABLE active_lesson
    ADD CONSTRAINT FK_ACTIVE_LESSON_ON_LEARNING_PROGRAMM FOREIGN KEY (learning_programm) REFERENCES course (id);

ALTER TABLE active_lesson
    ADD CONSTRAINT FK_ACTIVE_LESSON_ON_LESSON_TEMPLATE FOREIGN KEY (lesson_template_id) REFERENCES lessons_template (id);