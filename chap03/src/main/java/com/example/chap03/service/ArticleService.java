package com.example.chap03.service;

import com.example.chap03.dto.ArticlesDTO;
import com.example.chap03.entity.Article;
import com.example.chap03.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticlesDTO dto) {
        Article article = dto.toEntity();
        if(article.getId() != null){
            return null;
        }
        return articleRepository.save(article);
    }

    public Article update(Long id, ArticlesDTO dto) {
        Article article = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);
        if(target == null || id != article.getId()){
            return null;
        }
        target.patch(article);
        Article updated = articleRepository.save(article);
        return updated;
    }

    public Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);
        if(target == null){
            return null;
        }
        articleRepository.delete(target);
        return target;
    }

    public List<Article> createArticles(List<ArticlesDTO> dtos) {
        //1. dto 묶음을 엔티티 묶음으로 변환하기(스트림 문법)
        List<Article> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        //2. 엔티티 묶음을 DB에 저장
        articleList.stream().forEach(article -> articleRepository.save(article));

        //3. 강제 예외 발생시키기 (나중에 롤백 시키기 위함)
        articleRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("결제 실패!"));

        return articleList;
    }
}
