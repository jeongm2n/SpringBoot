package com.example.chap03.dto;

import com.example.chap03.entity.Article;

public class ArticlesDTO {
    private String title;
    private String content;

    public ArticlesDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticlesDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
