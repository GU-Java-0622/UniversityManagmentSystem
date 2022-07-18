package com.karalexsandr.coreservice.repository.schedule;

import com.karalexsandr.coreservice.model.Group;
import com.karalexsandr.coreservice.model.LearningProgramme;
import com.karalexsandr.coreservice.model.Lesson;
import com.karalexsandr.coreservice.model.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class ScheduleRepositoryImpl implements ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Schedule findById(Long id) {
        String query = "select s.id, s.started_at, " +
                "g.id as group_id, g.title as group_title, " +
                "lp.id as learning_programme_id, lp.title as learning_programme_title, " +
                "l.id as lesson_id, l.theme as lesson_theme " +
                "from schedules s " +
                "inner join groups g on g.id = s.group_id " +
                "inner join learning_programmes lp on lp.id = s.learning_programme_id " +
                "inner join lessons l on l.id = s.lesson_id " +
                "where s.id=:id";
        MapSqlParameterSource parameters = new MapSqlParameterSource("id", id);

        return namedParameterJdbcTemplate.query(query, parameters, rs -> {
            Schedule schedule = new Schedule();
            Map<Long, Group> groupMap = new HashMap<>();
            Map<Long, LearningProgramme> learningProgrammeMap = new HashMap<>();
            Map<Long, Lesson> lessonMap = new HashMap<>();

            while (rs.next()) {
                schedule.setId(rs.getLong("id"));
                schedule.setStartedAt(rs.getObject("started_at", LocalDateTime.class));

                Long groupKey = rs.getLong("group_id");
                Group group = groupMap.get(groupKey);
                if (group == null) {
                    group = new Group();
                    group.setId(groupKey);
                    group.setTitle(rs.getString("group_title"));
                    schedule.setGroup(group);
                }
                groupMap.put(groupKey, group);

                Long learningProgrammeKey = rs.getLong("learning_programme_id");
                LearningProgramme learningProgramme = learningProgrammeMap.get(learningProgrammeKey);
                if (learningProgramme == null) {
                    learningProgramme = new LearningProgramme();
                    learningProgramme.setId(learningProgrammeKey);
                    learningProgramme.setTitle(rs.getString("learning_programme_title"));
                    schedule.setLearningProgramme(learningProgramme);
                }
                learningProgrammeMap.put(learningProgrammeKey, learningProgramme);

                Long lessonKey = rs.getLong("lesson_id");
                Lesson lesson = lessonMap.get(lessonKey);
                if (lesson == null) {
                    lesson = new Lesson();
                    lesson.setId(lessonKey);
                    lesson.setTheme(rs.getString("lesson_theme"));
                    schedule.setLesson(lesson);
                }
            }
            return schedule;
        });
    }

    @Override
    public Page<Schedule> findAll(Pageable pageable) {
        String rowCount = "select count(*) from lessons";
        int count = jdbcTemplate.queryForObject(rowCount, Integer.class);

        String query = "select s.id, s.started_at, " +
                "g.id as group_id, g.title as group_title, " +
                "lp.id as learning_programme_id, lp.title as learning_programme_title, " +
                "l.id as lesson_id, l.theme as lesson_theme " +
                "from schedules s " +
                "inner join groups g on g.id = s.group_id " +
                "inner join learning_programmes lp on lp.id = s.learning_programme_id " +
                "inner join lessons l on l.id = s.lesson_id " +
                "limit " + pageable.getPageSize() + " " +
                "offset " + pageable.getOffset();

        List<Schedule> scheduleList = jdbcTemplate.query(query, rs -> {
            List<Schedule> schedules = new ArrayList<>();
            Map<Long, Schedule> scheduleMap = new HashMap<>();
            Map<Long, Group> groupMap = new HashMap<>();
            Map<Long, LearningProgramme> learningProgrammeMap = new HashMap<>();
            Map<Long, Lesson> lessonMap = new HashMap<>();

            while (rs.next()) {
                Long scheduleKey = rs.getLong("id");
                Schedule schedule = scheduleMap.get(scheduleKey);
                if (schedule == null) {
                    schedule = new Schedule();
                    schedule.setId(scheduleKey);
                    schedule.setStartedAt(rs.getObject("started_at", LocalDateTime.class));
                    schedules.add(schedule);
                }

                Long groupKey = rs.getLong("group_id");
                Group group = groupMap.get(groupKey);
                if (group == null) {
                    group = new Group();
                    group.setId(groupKey);
                    group.setTitle(rs.getString("group_title"));
                    schedule.setGroup(group);
                }
                groupMap.put(groupKey, group);

                Long learningProgrammeKey = rs.getLong("learning_programme_id");
                LearningProgramme learningProgramme = learningProgrammeMap.get(learningProgrammeKey);
                if (learningProgramme == null) {
                    learningProgramme = new LearningProgramme();
                    learningProgramme.setId(learningProgrammeKey);
                    learningProgramme.setTitle(rs.getString("learning_programme_title"));
                    schedule.setLearningProgramme(learningProgramme);
                }
                learningProgrammeMap.put(learningProgrammeKey, learningProgramme);

                Long lessonKey = rs.getLong("lesson_id");
                Lesson lesson = lessonMap.get(lessonKey);
                if (lesson == null) {
                    lesson = new Lesson();
                    lesson.setId(lessonKey);
                    lesson.setTheme(rs.getString("lesson_theme"));
                    schedule.setLesson(lesson);
                }
                lessonMap.put(lessonKey, lesson);
                scheduleMap.put(scheduleKey, schedule);
            }
            return schedules;
        });
        return new PageImpl<>(scheduleList, pageable, count);
    }
}
