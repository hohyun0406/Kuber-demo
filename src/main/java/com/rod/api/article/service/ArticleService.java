package com.rod.api.article.service;

import com.rod.api.article.model.Article;
import com.rod.api.article.model.ArticleDto;
import com.rod.api.common.service.CommandService;
import com.rod.api.common.service.QueryService;

import java.util.Optional;

public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {

    default Article dtoToEntity(ArticleDto dto){
        return Article.builder().build();
    }

    default ArticleDto entityToDto(Optional<Article> optional){
        return ArticleDto.builder().build();
    }

}




