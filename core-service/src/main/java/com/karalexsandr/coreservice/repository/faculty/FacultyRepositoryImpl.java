package com.karalexsandr.coreservice.repository.faculty;

import com.karalexsandr.coreservice.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class FacultyRepositoryImpl implements FacultyRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Page<Faculty> findAll(Pageable pageable) {
        String rowCount = "select count(*) from faculties";
        int count = jdbcTemplate.queryForObject(rowCount, Integer.class);


        String query = "select f.id,f.title, g.id as group_id, g.title as group_title, " +
                "gst.student_id as student_id, gst.teacher_id as teacher_id, " +
                "l.id as lesson_id, l.theme as lesson_theme, l.duration as lesson_duration," +
                "lp.id as learningProgramme_id, lp.title as learningProgramme_title, lp.status as learningProgramme_status, " +
                "lp.created_at as learningProgramme_created_at, lp.deprecated_at as learningProgramme_deprecate_at " +
                "from faculties as f " +
                "inner join faculties_group_learning_programme fglp on f.id = fglp.faculty_id " +
                "inner join groups g on g.id = fglp.group_id " +
                "inner join group_students_teachers gst on g.id = gst.group_id " +
                "inner join learning_programmes lp on lp.id = fglp.learning_programme_id " +
                "inner join learning_programmes_lessons lpl on lp.id = lpl.learning_programme_id " +
                "inner join lessons l on l.id = lpl.lesson_id " +
                "limit " + pageable.getPageSize() + " " +
                "offset " + pageable.getOffset();

        List<Faculty> facultyList =
                jdbcTemplate.query(query, rs -> {
                    List<Faculty> faculties = new ArrayList<>();
                    Map<Long, Faculty> facultyMap = new HashMap<>();
                    Map<Long, Group> groupMap = new HashMap<>();
                    Map<Long, LearningProgramme> learningProgrammeMap = new HashMap<>();
                    Map<Long, Lesson> lessonMap = new HashMap<>();

                    while (rs.next()) {
                        Long facultyKey = rs.getLong("id");
                        Faculty faculty = facultyMap.get(facultyKey);
                        if (faculty == null) {
                            faculty = new Faculty();
                            faculty.setId(facultyKey);
                            faculty.setTitle(rs.getString("title"));
                            faculties.add(faculty);
                        }

                        Long groupKey = rs.getLong("group_id");
                        Group group = groupMap.get(groupKey);
                        if (group == null) {
                            group = new Group();
                            if (faculty.getGroupList() == null) {
                                faculty.setGroupList(new ArrayList<Group>());
                            }
                            faculty.getGroupList().add(group);
                            group.setId(groupKey);
                            group.setTitle(rs.getString("group_title"));
                        }
                        if (group.getStudents() == null) {
                            group.setStudents(new ArrayList<Integer>());
                        }
                        if (group.getTeachers() == null) {
                            group.setTeachers(new ArrayList<Integer>());
                        }
                        group.getStudents().add(rs.getInt("student_id"));
                        group.getTeachers().add(rs.getInt("teacher_id"));
                        groupMap.put(groupKey, group);

                        long learningProgrammeKey = rs.getLong("learningProgramme_id");
                        LearningProgramme learningProgramme = learningProgrammeMap.get(learningProgrammeKey);
                        if (learningProgramme == null) {
                            learningProgramme = new LearningProgramme();
                            if (faculty.getLearningProgramme() == null) {
                                faculty.setLearningProgramme(new ArrayList<LearningProgramme>());
                            }
                            faculty.getLearningProgramme().add(learningProgramme);
                            learningProgramme.setId(learningProgrammeKey);
                            learningProgramme.setTitle(rs.getString("learningProgramme_title"));
                            learningProgramme.setStatus(StatusEnum.valueOf(rs.getString("learningProgramme_status")));
                            learningProgramme.setCreateAt(rs.getObject("learningProgramme_created_at", LocalDateTime.class));
                            learningProgramme.setDeprecatedUp(rs.getObject("learningProgramme_deprecate_at", LocalDateTime.class));
                        }
                        if (learningProgramme.getLessonList() == null) {
                            learningProgramme.setLessonList(new ArrayList<>());
                        }
                        Long lessonKey = rs.getLong("lesson_id");
                        Lesson lesson = lessonMap.get(lessonKey);
                        if (lesson == null) {
                            lesson = new Lesson();
                            lesson.setId(lessonKey);
                            lesson.setTheme(rs.getString("lesson_theme"));
                            lesson.setDuration(rs.getObject("lesson_duration", LocalTime.class));
                            learningProgramme.getLessonList().add(lesson);
                        }
                        lessonMap.put(lessonKey, lesson);
                        learningProgrammeMap.put(learningProgrammeKey, learningProgramme);
                        facultyMap.put(facultyKey, faculty);
                    }

                    return faculties;
                });
        return new PageImpl<>(facultyList, pageable, count);
    }

    @Override
    public Faculty findByTitle(String title) {
        String query = "select f.id as id,f.title as title," +
                " g.id as group_id, g.title as group_title, " +
                "gst.student_id as student_id, gst.teacher_id as teacher_id, " +
                "l.id as lesson_id, l.theme as lesson_theme, l.duration as lesson_duration," +
                "lp.id as learningProgramme_id, lp.title as learningProgramme_title, lp.status as learningProgramme_status, " +
                "lp.created_at as learningProgramme_created_at, lp.deprecated_at as learningProgramme_deprecate_at " +
                "from faculties as f " +
                "inner join faculties_group_learning_programme fglp on f.id = fglp.faculty_id " +
                "inner join groups g on g.id = fglp.group_id " +
                "inner join group_students_teachers gst on g.id = gst.group_id " +
                "inner join learning_programmes lp on lp.id = fglp.learning_programme_id " +
                "inner join learning_programmes_lessons lpl on lp.id = lpl.learning_programme_id " +
                "inner join lessons l on l.id = lpl.lesson_id " +
                "where f.title=:title";
        MapSqlParameterSource parameters = new MapSqlParameterSource("title", title);

        return namedParameterJdbcTemplate.query(query,parameters,rs->{
            Faculty faculty = new Faculty();

            Map<Long, Group> groupMap = new HashMap<>();
            Map<Long, LearningProgramme> learningProgrammeMap = new HashMap<>();
            Map<Long, Lesson> lessonMap = new HashMap<>();

            while (rs.next()) {
                faculty.setId(rs.getLong("id"));
                faculty.setTitle(rs.getString("title"));

                Long groupKey = rs.getLong("group_id");
                Group group = groupMap.get(groupKey);
                if (group == null) {
                    group = new Group();
                    if (faculty.getGroupList() == null) {
                        faculty.setGroupList(new ArrayList<Group>());
                    }
                    faculty.getGroupList().add(group);
                    group.setId(groupKey);
                    group.setTitle(rs.getString("group_title"));
                }
                if (group.getStudents() == null) {
                    group.setStudents(new ArrayList<Integer>());
                }
                if (group.getTeachers() == null) {
                    group.setTeachers(new ArrayList<Integer>());
                }
                group.getStudents().add(rs.getInt("student_id"));
                group.getTeachers().add(rs.getInt("teacher_id"));
                groupMap.put(groupKey, group);

                long learningProgrammeKey = rs.getLong("learningProgramme_id");
                LearningProgramme learningProgramme = learningProgrammeMap.get(learningProgrammeKey);
                if (learningProgramme == null) {
                    learningProgramme = new LearningProgramme();
                    if (faculty.getLearningProgramme() == null) {
                        faculty.setLearningProgramme(new ArrayList<LearningProgramme>());
                    }
                    faculty.getLearningProgramme().add(learningProgramme);
                    learningProgramme.setId(learningProgrammeKey);
                    learningProgramme.setTitle(rs.getString("learningProgramme_title"));
                    learningProgramme.setStatus(StatusEnum.valueOf(rs.getString("learningProgramme_status")));
                    learningProgramme.setCreateAt(rs.getObject("learningProgramme_created_at", LocalDateTime.class));
                    learningProgramme.setDeprecatedUp(rs.getObject("learningProgramme_deprecate_at", LocalDateTime.class));
                }
                if (learningProgramme.getLessonList() == null) {
                    learningProgramme.setLessonList(new ArrayList<>());
                }
                Long lessonKey = rs.getLong("lesson_id");
                Lesson lesson = lessonMap.get(lessonKey);
                if (lesson == null) {
                    lesson = new Lesson();
                    lesson.setId(lessonKey);
                    lesson.setTheme(rs.getString("lesson_theme"));
                    lesson.setDuration(rs.getObject("lesson_duration", LocalTime.class));
                    learningProgramme.getLessonList().add(lesson);
                }
                lessonMap.put(lessonKey, lesson);
                learningProgrammeMap.put(learningProgrammeKey, learningProgramme);
            }
            return faculty;
        });
    }
}
