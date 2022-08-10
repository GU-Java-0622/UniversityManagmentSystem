package ru.geekbrains.additionaly.news.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import ru.geekbrains.additionaly.Status;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsModel {
    @Id
    private Long id;
    private Long author;
    private String title;
    private String content;
    private Status status;
    private LocalDateTime created;
    private LocalDateTime updated;
}

