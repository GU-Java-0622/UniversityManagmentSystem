package ru.geekbrains.additionaly.news.service;


import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.additionaly.Status;
import ru.geekbrains.additionaly.news.mappers.NewsModelRowMapper;
import ru.geekbrains.additionaly.news.models.NewsDtoRequest;
import ru.geekbrains.additionaly.news.models.NewsModel;
import ru.geekbrains.additionaly.news.repository.NewsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService{
    private final String GET_LAST_FOUR_NEWS ="SELECT * from news where status=:status order by created_at desc limit :limit";
    private final String UPDATE_NEWS="UPDATE news as n set n.author=:author,n.title=:title," +
            "n.content=:content where n.id=:id";
    private final String INSERT_NEWS="INSERT INTO news (author,title,content,status,created_at) " +
            "VALUES (:author,:title,:content,:status,:createdAt)";
    private final NewsRepository newsRepository;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean delete(Long id){
       return newsRepository.updateStatus(id,Status.DELETED);
   }
    @Transactional
   public int save(NewsDtoRequest request){
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("author", request.getAuthorId());
        parameterSource.addValue("title", request.getTitle());
        parameterSource.addValue("content", request.getContent());

        if(request.getId()==null) {
            parameterSource.addValue("status",Status.ACTIVE.toString());
            parameterSource.addValue("createdAt",LocalDateTime.now());
            return namedParameterJdbcTemplate.update(INSERT_NEWS,parameterSource);
        }
        parameterSource.addValue("id", request.getId());
        return namedParameterJdbcTemplate.update(UPDATE_NEWS,parameterSource);

   }

    @Override
    public List<NewsModel> getNewsForWelcomePage() {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("status",Status.ACTIVE.toString());
        parameterSource.addValue("limit",4);
        return namedParameterJdbcTemplate.query(GET_LAST_FOUR_NEWS,parameterSource, new NewsModelRowMapper());
    }
}
