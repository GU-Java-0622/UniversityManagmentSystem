package ru.geekbrains.additionaly.news.service;



import ru.geekbrains.additionaly.news.models.NewsDtoRequest;
import ru.geekbrains.additionaly.news.models.NewsModel;

import java.util.List;

public interface NewsService {
    boolean delete(Long id);
    int save(NewsDtoRequest request);
    List<NewsModel> getNewsForWelcomePage();
}
