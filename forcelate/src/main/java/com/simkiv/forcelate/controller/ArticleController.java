package com.simkiv.forcelate.controller;

import com.simkiv.forcelate.dto.ArticleDto;
import com.simkiv.forcelate.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}/articles")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ResponseEntity<ArticleDto> save(@RequestBody ArticleDto articleDto) {
        ArticleDto savedArticle = articleService.save(articleDto);
        return ResponseEntity.ok().body(savedArticle);
    }

    @RequestMapping
    public ResponseEntity<ArticleDto> getOne(@PathVariable("articleId") long id) {
        return ResponseEntity.ok().body(articleService.getOne(id));
    }
}
