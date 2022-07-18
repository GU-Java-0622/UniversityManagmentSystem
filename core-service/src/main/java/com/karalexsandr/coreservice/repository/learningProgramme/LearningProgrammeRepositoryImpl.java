package com.karalexsandr.coreservice.repository.learningProgramme;

import com.karalexsandr.coreservice.model.LearningProgramme;
import com.karalexsandr.coreservice.model.Lesson;
import com.karalexsandr.coreservice.model.StatusEnum;
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

@Repository
@RequiredArgsConstructor
public class LearningProgrammeRepositoryImpl implements LearningProgrammeRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public LearningProgramme findByTitle(String title) {
        String query = "select lp.id,lp.title,lp.status,lp.created_at,lp.deprecated_at," +
                "l.id as lesson_id, l.theme as lesson_theme,l.duration as lesson_duration " +
                "from learning_programmes_lessons as lpl " +
                "inner join learning_programmes lp on lp.id = lpl.learning_programme_id " +
                "inner join lessons l on l.id = lpl.lesson_id " +
                "where lp.title=:title";
        MapSqlParameterSource parameters = new MapSqlParameterSource("title", title);
        return namedParameterJdbcTemplate.query(query, parameters, rs -> {
            LearningProgramme learningProgramme = new LearningProgramme();
            while (rs.next()) {
                learningProgramme.setId(rs.getLong("id"));
                learningProgramme.setTitle(rs.getString("title"));
                learningProgramme.setStatus(StatusEnum.valueOf(rs.getString("status")));
                learningProgramme.setCreateAt(rs.getObject("created_at", LocalDateTime.class));
                learningProgramme.setDeprecatedUp(rs.getObject("deprecated_at", LocalDateTime.class));

                if (learningProgramme.getLessonList() == null) {
                    learningProgramme.setLessonList(new ArrayList<>());
                }
                learningProgramme.getLessonList().add(new Lesson(
                        rs.getLong("lesson_id"),
                        rs.getString("lesson_theme"),
                        rs.getObject("lesson_duration", LocalTime.class)));
            }
            return learningProgramme;
        });
    }

    @Override
    public Page<LearningProgramme> findAll(Pageable pageable) {
        String rowCount = "select count(*) from learning_programmes";
        int count = jdbcTemplate.queryForObject(rowCount, Integer.class);

        String query = "select lp.id,lp.title,lp.status,lp.created_at,lp.deprecated_at," +
                "l.id as lesson_id, l.theme as lesson_theme,l.duration as lesson_duration " +
                "from learning_programmes_lessons as lpl " +
                "inner join learning_programmes lp on lp.id = lpl.learning_programme_id " +
                "inner join lessons l on l.id = lpl.lesson_id " +
                "limit " + pageable.getPageSize() + " " +
                "offset " + pageable.getOffset();

        List<LearningProgramme> learningProgrammeList = jdbcTemplate.query(query, rs -> {
            List<LearningProgramme> learningProgrammes = new ArrayList<>();
            Map<Long, LearningProgramme> learningProgrammeMap = new HashMap<>();

            while (rs.next()) {
                Long learningProgrammeKey = rs.getLong("id");
                LearningProgramme learningProgramme = learningProgrammeMap.get(learningProgrammeKey);
                if (learningProgramme == null) {
                    learningProgramme = new LearningProgramme();
                    learningProgrammes.add(learningProgramme);
                    learningProgramme.setId(learningProgrammeKey);
                    learningProgramme.setTitle(rs.getString("title"));
                    learningProgramme.setStatus(StatusEnum.valueOf(rs.getString("status")));
                    learningProgramme.setCreateAt(rs.getObject("created_at", LocalDateTime.class));
                    learningProgramme.setDeprecatedUp(rs.getObject("deprecated_at", LocalDateTime.class));
                }
                if (learningProgramme.getLessonList() == null) {
                    learningProgramme.setLessonList(new ArrayList<>());
                }
                learningProgramme.getLessonList().add(new Lesson(
                        rs.getLong("lesson_id"),
                        rs.getString("lesson_theme"),
                        rs.getObject("lesson_duration", LocalTime.class)));
                learningProgrammeMap.put(learningProgrammeKey, learningProgramme);
            }
            return learningProgrammes;
        });
        return new PageImpl<>(learningProgrammeList, pageable, count);
    }
}
