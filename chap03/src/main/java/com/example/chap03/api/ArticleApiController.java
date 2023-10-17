package com.example.chap03.api;

import com.example.chap03.dto.ArticlesDTO;
import com.example.chap03.entity.Article;
import com.example.chap03.repository.ArticleRepository;
import com.example.chap03.service.ArticleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired
    private ArticleRepository articleRepository;
//
//    @GetMapping("/api/articles")
//    public List<Article> index(){
//        return articleRepository.findAll();
//    }

//    @GetMapping("/api/articles/{id}")
//    public Article show(@PathVariable Long id){
//        return articleRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping("api/articles")
//    public Article create(@RequestBody ArticlesDTO dto){
//        Article article = dto.toEntity();
//        return articleRepository.save(article);
//    }
//
//    @PatchMapping("/api/articles/{id}")
//    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticlesDTO dto){
//        Article article = dto.toEntity();
//        Article target = articleRepository.findById(id).orElse(null);
//        if(target == null || id != article.getId()){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        target.patch(article);
//        Article updated = articleRepository.save(article);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }
//
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Article> delete(@PathVariable Long id){
//        Article target = articleRepository.findById(id).orElse(null);
//        if(target == null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        articleRepository.delete(target);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
    @Autowired
    private ArticleService articleService;
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleService.show(id);
    }

    @PostMapping("api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticlesDTO dto){
        Article created = articleService.create(dto);

        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
