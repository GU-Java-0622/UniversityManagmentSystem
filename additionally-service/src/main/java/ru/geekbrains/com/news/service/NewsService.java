package ru.geekbrains.com.news.service;



import ru.geekbrains.com.news.models.NewsDtoRequest;
import ru.geekbrains.com.news.models.NewsModel;

import java.util.List;

public interface NewsService {
    boolean delete(Long id);
    int save(NewsDtoRequest request);
    List<NewsModel> getNewsForWelcomePage();
}
