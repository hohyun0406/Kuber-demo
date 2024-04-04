package com.rod.api.board;

import com.rod.api.article.Article;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Component
@Data
@Builder
public class BoardDto {
    private Long id;
    private String boardName;
    private String boardType;
    private String registerDate;
    private List<Article> articles;

}