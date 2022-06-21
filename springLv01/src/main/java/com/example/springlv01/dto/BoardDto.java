package com.example.springlv01.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;


@Getter
public class BoardDto {
    private String title;
    private String writer;
    private String content;

}
