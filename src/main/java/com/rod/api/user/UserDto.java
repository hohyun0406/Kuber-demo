package com.rod.api.user;

import com.rod.api.article.Article;

import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Component
@Data
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String job;
    private List<Article> articlesId;
}
