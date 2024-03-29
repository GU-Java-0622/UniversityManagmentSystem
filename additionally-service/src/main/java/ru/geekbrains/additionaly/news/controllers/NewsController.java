package ru.geekbrains.additionaly.news.controllers;



import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.additionaly.news.models.NewsDtoRequest;
import ru.geekbrains.additionaly.news.models.NewsModel;
import ru.geekbrains.additionaly.news.service.NewsService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news")
public class NewsController {
    private final NewsService newsService;

    @GetMapping("/welcome_page")
    public List<NewsModel> getNewsForWelcomePage(){
        return newsService.getNewsForWelcomePage();
    }

    @PostMapping("/save")
    public int saveOrUpdate(@RequestBody NewsDtoRequest newsDtoRequest){
       return newsService.save(newsDtoRequest);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable Long id){
        return newsService.delete(id);
    }

}
