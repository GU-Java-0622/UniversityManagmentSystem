create table programme_template_faculties
(
    programme_template_id bigint not null
        constraint fkp3rj6d124ptbkphotjr97l51u
            references stream_template,
    faculty_id            bigint not null
        constraint fkruce9gd8lp44bu9itrjsxgtaq
            references course_template
);

insert into programme_template_faculties(programme_template_id, faculty_id)
VALUES (1,1),
       (2,2);