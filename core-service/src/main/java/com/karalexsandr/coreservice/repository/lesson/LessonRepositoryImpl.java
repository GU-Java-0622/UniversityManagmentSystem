package com.karalexsandr.coreservice.repository.lesson;

import com.karalexsandr.coreservice.model.Lesson;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.*;

@RequiredArgsConstructor
@Repository
public class LessonRepositoryImpl implements LessonRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Lesson findByTheme(String theme) {
        String query = "select l.id as id, l.theme as theme, l.duration as duration " +
                "from lessons l " +
                "where theme=:theme";

        MapSqlParameterSource parameters = new MapSqlParameterSource("theme", theme);
        return namedParameterJdbcTemplate.query(query, parameters, rs -> {
            Lesson lesson = new Lesson();
            while (rs.next()) {
                lesson = new Lesson();
                lesson.setId(rs.getLong("id"));
                lesson.setTheme(rs.getString("theme"));
                lesson.setDuration(rs.getObject("duration", LocalTime.class));
            }
            return lesson;
        });
    }

    @Override
    public Page<Lesson> findAll(Pageable pageable) {
        String rowCount = "select count(*) from lessons";
        int count = jdbcTemplate.queryForObject(rowCount, Integer.class);

        String query = "select l.id, l.theme, l.duration " +
                "from lessons l " +
                "limit " + pageable.getPageSize() + " " +
                "offset " + pageable.getOffset();

        List<Lesson> lessons = jdbcTemplate.query(query, rs -> {
            List<Lesson> lessonList = new ArrayList<>();
            Map<Long, Lesson> lessonMap = new HashMap<>();

            while (rs.next()) {
                Long lessonKey = rs.getLong("id");
                Lesson lesson = lessonMap.get(lessonKey);
                if (lesson == null) {
                    lesson = new Lesson();
                    lesson.setId(lessonKey);
                    lesson.setTheme(rs.getString("theme"));
                    lesson.setDuration(rs.getObject("duration", LocalTime.class));
                    lessonList.add(lesson);
                }
                lessonMap.put(lessonKey, lesson);
            }
            return lessonList;
        });

        return new PageImpl<>(lessons, pageable, count);
    }
}
