package com.example.springlv01.service;

import com.example.springlv01.dto.CommentDto;
import com.example.springlv01.model.Comment;
import com.example.springlv01.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    // 댓글 목록 조회         **************  commentRepository에서 할 필요가 있는지
    public Optional<Comment> getCommentList(Long boardId) {
//        List<Comment> commentList = commentRepository.findById(boardId);
        Optional<Comment> commentList = commentRepository.findById(boardId);
        return commentList;
    }
    // 댓글 작성
    public String createComment(CommentDto commentDto) {
        if(commentDto.equals("")) {
            return "댓글 내용 입력해주세요.";
        }
        Comment comment = new Comment(commentDto);
        commentRepository.save(comment);
        return "댓글을 작성하였습니다.";
    }
    // 댓글 수정
    public String modifyComment(Long commentId, CommentDto commentDto) {
        if(commentDto.equals("")) {
            return "댓글 내용 입력해주세요.";
        }
        Comment comment = new Comment(commentDto);
        return "댓글 수정 완료";
    }
    // 댓글 삭제
    public Long removeComment(Long commentId) {
        commentRepository.deleteById(commentId);
        return commentId;
    }
}
