package com.example.chap03.controller;

import com.example.chap03.dto.ArticlesDTO;
import com.example.chap03.entity.Article;
import com.example.chap03.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
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
        log.info(articlesDTO.toString());
        Article article = articlesDTO.toEntity();
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        log.info(article.toString());
        return "";
    }
}
