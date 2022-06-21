package com.example.springlv01.dto;


import lombok.Getter;

@Getter
public class CommentDto {
    private Long board_id;
    private String content;
    private String writer;
}
