package com.playground.shopping.member.controller;

import com.playground.shopping.member.model.request.MemberRequest;
import com.playground.shopping.member.service.BoardService;
import com.playground.shopping.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
