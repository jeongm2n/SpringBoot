package com.example.chap03.controller;

import com.example.chap03.dto.ArticlesDTO;
import com.example.chap03.entity.Article;
import com.example.chap03.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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
        return "/articles/new";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);

        //1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        //2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);

        //3. 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //1. 모든 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();

        //2. 모델에 데이터 등록하기
        model.addAttribute("articleList",articleEntityList);

        //3. 뷰 페이지 설정하기
        return "articles/index";
    }
}
