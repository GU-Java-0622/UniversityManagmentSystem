package com.karalexsandr.coreservice.repository.group;

import com.karalexsandr.coreservice.model.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class GroupRepositoryImpl implements GroupRepository{
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public Group findByTitle(String title) {
        String query = "select g.id,g.title, gst.student_id, gst.teacher_id " +
                "from group_students_teachers gst " +
                "inner join groups g on g.id = gst.group_id " +
                "where g.title=:title";
        MapSqlParameterSource parameters = new MapSqlParameterSource("title", title);
        return namedParameterJdbcTemplate.query(query,parameters,rs -> {
            Group group = new Group();
            while (rs.next()){
                group.setId(rs.getLong("id"));
                group.setTitle(rs.getString("title"));
                if (group.getStudents() == null) {
                    group.setStudents(new ArrayList<>());
                }
                if (group.getTeachers() == null) {
                    group.setTeachers(new ArrayList<>());
                }
                group.getStudents().add(rs.getInt("student_id"));
                group.getTeachers().add(rs.getInt("teacher_id"));
            }
            return group;
        });
    }

    @Override
    public Page<Group> findAll(Pageable pageable) {
        String rowCount = "select count(*) from groups";
        int count = jdbcTemplate.queryForObject(rowCount, Integer.class);

        String query = "select g.id,g.title, gst.student_id, gst.teacher_id " +
                "from group_students_teachers gst " +
                "inner join groups g on g.id = gst.group_id " +
                "limit " + pageable.getPageSize() + " " +
                "offset " + pageable.getOffset();

        List<Group> groupList = jdbcTemplate.query(query, rs -> {

            List<Group> groups = new ArrayList<>();
            Map<Long, Group> groupMap = new HashMap<>();

            while (rs.next()) {
                Long groupId = rs.getLong("id");
                Group group = groupMap.get(groupId);
                if (group == null) {
                    group = new Group();
                    group.setId(groupId);
                    group.setTitle(rs.getString("title"));
                    groups.add(group);
                }
                if (group.getStudents() == null) {
                    group.setStudents(new ArrayList<>());
                }
                if (group.getTeachers() == null) {
                    group.setTeachers(new ArrayList<>());
                }
                group.getStudents().add(rs.getInt("student_id"));
                group.getTeachers().add(rs.getInt("teacher_id"));
                groupMap.put(groupId, group);
            }
            return groups;
        });
        return new PageImpl<>(groupList,pageable,count);
    }
}
