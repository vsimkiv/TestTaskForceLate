package com.simkiv.forcelate.service;

import com.simkiv.forcelate.dto.ArticleDto;
import com.simkiv.forcelate.entity.Article;
import com.simkiv.forcelate.entity.Color;
import com.simkiv.forcelate.repository.ArticleRepo;
import com.simkiv.forcelate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepo articleRepo;
    private UserRepo userRepo;


    @Autowired
    public ArticleServiceImpl(ArticleRepo articleRepo, UserRepo userRepo) {
        this.articleRepo = articleRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        articleRepo.save(toEntity(articleDto));
        return articleDto;
    }

    @Override
    public ArticleDto getOne(long id) {
        return toDto(articleRepo.getOne(id));
    }


    private ArticleDto toDto(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .color(article.getColor().name())
                .authorId(article.getAuthor().getId())
                .build();
    }

    private Article toEntity(ArticleDto articleDto) {
        return Article.builder()
                .id(articleDto.getId())
                .color(Color.valueOf(articleDto.getColor()))
                .author(userRepo.getOne(articleDto.getAuthorId()))
                .build();
    }
}
