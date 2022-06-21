package com.example.springlv01.service;

import com.example.springlv01.dto.BoardDto;
import com.example.springlv01.model.Board;
import com.example.springlv01.repository.BoardRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BoardService {

    private final BoardRepository boardRepository;

    BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    // 전체 게시글 목록 조회 기능 구현
    public List<Board> getBoardList() {
//        System.out.println(boardRepository.findAllByOrderByModifiedAtDesc().get(0));
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }
    // 게시글 작성 구현
    public void createBoard(BoardDto boardDto) {
        Board board = new Board(boardDto);
        boardRepository.save(board);
    }
    // 게시글 조회 구현                     ***********************   왜 Optional????????????    ***********************
    public Optional<Board> readBoard(Long boardId) {
        // Board board = boardRepository.findById(boardId);
        Optional<Board> board = boardRepository.findById(boardId);
        return board;
    }
    // 게시글 수정 구현
    public Board modifyBoard(Long boardId, BoardDto boardDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new IllegalArgumentException("잘못된 Id입니다.")
        );
        board.update(boardDto);
        boardRepository.save(board);
        return board;
    }
    // 게시글 삭제 구현
    public void removeBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
