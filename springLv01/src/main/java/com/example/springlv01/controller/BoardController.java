package com.example.springlv01.controller;


import com.example.springlv01.dto.BoardDto;
import com.example.springlv01.model.Board;
import com.example.springlv01.repository.BoardRepository;
import com.example.springlv01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventPublicationInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

//    @Autowired
    private final BoardService boardService;
//    @Autowired
//    BoardController(BoardService boardService) {
//        this.boardService = boardService;
//    }
    //전체 게시글 목록 조회
    @GetMapping("/api/boards")
    public List<Board> getBoards() {
        return boardService.getBoardList();
    }
    // 게시글 작성
    @PostMapping("/api/boards")
    // @RequestBody는 클라이언트로부터 JSON으로 받은 데이터 요청을 객체로 변환해주는 것
    public void writeBoard(@RequestBody BoardDto boardDto) {
        boardService.createBoard(boardDto);
    }
    // 게시글 조회
    @GetMapping("/api/boards/{boardId}")
    public void getBoard(@PathVariable Long boardId) {
         boardService.readBoard(boardId);
    }
    // 게시글 수정
    @PutMapping("/api/boards/{boardId}")
    public void updateBoard(@PathVariable Long boardId, @RequestBody BoardDto boardDto) {
        boardService.modifyBoard(boardId, boardDto);
    }
    // 게시글 삭제
    @DeleteMapping("/api/boards/{boardId}")
    public void deleteBoard(@PathVariable Long boardId) {
        boardService.removeBoard(boardId);
    }
}
