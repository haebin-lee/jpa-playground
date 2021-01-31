package com.playground.shopping.member.service;

import com.playground.shopping.member.entity.Board;
import com.playground.shopping.member.entity.BoardRepository;
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
