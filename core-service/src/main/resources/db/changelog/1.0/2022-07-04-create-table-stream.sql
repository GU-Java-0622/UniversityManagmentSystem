CREATE TABLE active_stream
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    stream_template_id BIGINT,
    created_at         date,
    status_stream      VARCHAR(255),
    facultity_id       BIGINT,
    CONSTRAINT pk_active_stream PRIMARY KEY (id)
);

ALTER TABLE active_stream
    ADD CONSTRAINT FK_ACTIVE_STREAM_ON_FACULTITY FOREIGN KEY (facultity_id) REFERENCES faculties (id);

ALTER TABLE active_stream
    ADD CONSTRAINT FK_ACTIVE_STREAM_ON_STREAM_TEMPLATE FOREIGN KEY (stream_template_id) REFERENCES stream_template (id);