package ru.geekbrains.com.news.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class NewsDtoRequest {
    private Long id;
    private Long authorId;
    private String title;
    private String content;
}
