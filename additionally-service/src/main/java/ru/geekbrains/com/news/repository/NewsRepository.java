package ru.geekbrains.com.news.repository;



import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.geekbrains.com.Status;
import ru.geekbrains.com.news.models.NewsModel;


public interface NewsRepository  extends CrudRepository<NewsModel,Long> {
    @Modifying
    @Query("UPDATE news SET status = :status WHERE id = :id")
    boolean updateStatus(@Param("id") Long id, @Param("status") Status status);
}