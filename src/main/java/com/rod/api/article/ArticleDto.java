package com.rod.api.article;

import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Component
@Data
@Builder
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private String registerDate;
    private Long writerId;
    private Long boardId;
}
