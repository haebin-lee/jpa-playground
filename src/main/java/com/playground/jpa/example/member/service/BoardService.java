package com.playground.jpa.example.member.service;

import com.playground.jpa.example.member.entity.Board;
import com.playground.jpa.example.member.entity.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Long addBoard(String data) {
        Board board = Board.builder()
                .data(data)
                .build();

        boardRepository.save(board);
        return board.getId();
    }
}
