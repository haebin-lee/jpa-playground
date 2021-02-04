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

    @PutMapping("/member/{memberId}")
    public void updateMember(
            @PathVariable Long memberId,
            @RequestBody MemberRequest.UpdateMember updateMember) {
        memberService.updateMemberTeam(memberId, updateMember.getUserName(), updateMember.getTeamName());
    }

    @DeleteMapping("/member/{memberId}/team")
    public void deleteTeamFromUser(
            @PathVariable Long memberId) {
        memberService.deleteTeamFromMember(memberId);
    }
}
