package com.example.springlv01.controller;


import com.example.springlv01.dto.CommentDto;
import com.example.springlv01.model.Comment;
import com.example.springlv01.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
// View로 응답하지 않는 Controller를 의미함. JSON 형태로 반환할 때 쓰는데 쉽게 얘기하면 html(View) 파일 없을 때 씀.
@RestController
public class CommentController {

    private final CommentService commentService;

//    CommentController(CommentService commentService) {
//        this.commentService = commentService;
//    }
    //댓글 목록 조회
    @GetMapping("/api/comments/{boardId}")
    public Optional<Comment> getComments(@PathVariable Long boardId) {
        return commentService.getCommentList(boardId);
    }
    //댓글 작성
    @PostMapping("/api/comments")
    public void writeComment(@RequestBody CommentDto commentDto) {
        commentService.createComment(commentDto);
    }
    // 댓글 수정
    @PutMapping("/api/comments/{commentId}")
    public String updateComment(@PathVariable Long commentId, @RequestBody CommentDto commentDto) {
        return commentService.modifyComment(commentId, commentDto);
    }
    // 댓글 삭제
    @DeleteMapping("/api/comments/{commentId}")
    public Long deleteComment(@PathVariable Long commentId) {
        return commentService.removeComment(commentId);
    }


}