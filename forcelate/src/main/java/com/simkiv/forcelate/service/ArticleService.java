package com.simkiv.forcelate.service;

import com.simkiv.forcelate.dto.ArticleDto;

public interface ArticleService {
    ArticleDto save(ArticleDto articleDto);

    ArticleDto getOne(long id);
}
