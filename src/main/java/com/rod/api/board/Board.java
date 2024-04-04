package com.rod.api.board;

import com.rod.api.article.Article;
import com.rod.api.common.query.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Board extends BaseEntity {
    @Id
    @Column(name = "board_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String boardName;
    private String boardType;

    @OneToMany(mappedBy = "board")
    private List<Article> articles;

    @Builder(builderMethodName = "builder")
    public Board(Long id, String boardName, String boardType) {
        this.id = id;
        this.boardName = boardName;
        this.boardType = boardType;
    }
}