package com.playground.jpa.member.controller;

import com.playground.jpa.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public Long addBoard(String data) {
        return boardService.addBoard(data);
    }
}
