package ru.geekbrains.com.news.mappers;

import org.springframework.jdbc.core.RowMapper;
import ru.geekbrains.com.news.models.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class NewsModelRowMapper implements RowMapper<NewsModel> {
    @Override
    public NewsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        NewsModel model = new NewsModel();
        model.setId(rs.getLong("id"));
        model.setAuthor(rs.getLong("author"));
        model.setTitle(rs.getString("title"));
        model.setContent(rs.getString("content"));
        model.setCreated(rs.getObject("created_at", LocalDateTime.class));
        model.setUpdated(rs.getObject("updated_at", LocalDateTime.class));
        return model;
    }
}
