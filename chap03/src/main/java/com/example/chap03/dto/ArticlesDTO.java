package com.example.chap03.dto;

import com.example.chap03.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString

public class ArticlesDTO {
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
