package com.rod.api.article;

import com.rod.api.board.Board;
import com.rod.api.common.query.BaseEntity;
import com.rod.api.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j;

@Entity(name = "articles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = {"id"})
public class Article extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(nullable = true)
    private User writer;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Board board;


}
