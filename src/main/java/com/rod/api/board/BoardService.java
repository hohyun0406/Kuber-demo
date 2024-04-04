package com.rod.api.board;

import com.rod.api.article.ArticleDto;
import com.rod.api.common.command.CommandService;
import com.rod.api.common.query.QueryService;

import java.util.ArrayList;
import java.util.List;

public interface BoardService extends CommandService, QueryService {

    List<ArticleDto> articleList = new ArrayList<>();
}
