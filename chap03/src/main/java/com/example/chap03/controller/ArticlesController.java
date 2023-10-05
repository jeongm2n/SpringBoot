package com.example.chap03.controller;

import com.example.chap03.dto.ArticlesDTO;
import com.example.chap03.entity.Article;
import com.example.chap03.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticlesController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newAtricleForm(){
        return "articles/new";
    }

    @GetMapping("/articles/create")
    public String createArticle(ArticlesDTO articlesDTO){
        System.out.println(articlesDTO.toString());

        Article article = articlesDTO.toEntity();
        System.out.println(article.toString());

        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
