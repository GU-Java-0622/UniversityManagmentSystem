CREATE TABLE course
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    title              VARCHAR(255),
    course_template_id BIGINT,
    stream_id          BIGINT,
    person_id          BIGINT,
    CONSTRAINT pk_course PRIMARY KEY (id)
);

ALTER TABLE course
    ADD CONSTRAINT FK_COURSE_ON_COURSE_TEMPLATE FOREIGN KEY (course_template_id) REFERENCES course_template (id);

ALTER TABLE course
    ADD CONSTRAINT FK_COURSE_ON_PERSON FOREIGN KEY (person_id) REFERENCES persons (id);

ALTER TABLE course
    ADD CONSTRAINT FK_COURSE_ON_STREAM FOREIGN KEY (stream_id) REFERENCES active_stream (id);