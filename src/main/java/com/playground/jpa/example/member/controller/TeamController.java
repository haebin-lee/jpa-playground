package com.playground.jpa.example.member.controller;

import com.playground.jpa.example.member.entity.Member;
import com.playground.jpa.example.member.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class TeamController {

    public final TeamService teamService;

    @GetMapping("/team/{teamId}/members")
    public List<Member> getMemberList(
            @PathVariable Long teamId) {
        List<Member> memberList = teamService.getMemberList(teamId);
        Optional.ofNullable(memberList).ifPresent(m -> {
            m.forEach(System.out::println);
        });
        return memberList;
    }
}
