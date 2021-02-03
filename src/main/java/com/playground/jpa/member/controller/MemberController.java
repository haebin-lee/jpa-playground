package com.playground.jpa.member.controller;

import com.playground.jpa.member.entity.Member;
import com.playground.jpa.member.model.request.MemberRequest;
import com.playground.jpa.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public Member getMember(@PathVariable Long memberId) {
        return memberService.getMember(memberId);
    }

    @PostMapping("/member")
    public Long addMember(@RequestBody MemberRequest memberRequest) {
        return memberService.addMember(memberRequest);
    }

}
