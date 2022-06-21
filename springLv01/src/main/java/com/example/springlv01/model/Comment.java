package com.example.springlv01.model;

import com.example.springlv01.dto.CommentDto;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Comment extends Timestamped {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private long boardId;

    @Column(nullable = false)
    private String content;

    public Comment(CommentDto commentDto) {
        this.boardId = commentDto.getBoard_id();
        this.content = commentDto.getContent();
    }
}
