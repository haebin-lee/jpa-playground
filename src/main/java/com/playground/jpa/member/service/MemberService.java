package com.playground.jpa.member.service;

import com.playground.jpa.member.entity.Member;
import com.playground.jpa.member.entity.MemberRepository;
import com.playground.jpa.member.entity.Team;
import com.playground.jpa.member.entity.TeamRepository;
import com.playground.jpa.member.model.request.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    public List<Member> getMemberList(){
        return memberRepository.findAll();
    }

    public Member getMember(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        return member.orElseGet(null);
    }

    public Long addMember(MemberRequest memberRequest) {
        Team team = new Team(memberRequest.getTeamName());

        Member member = new Member();
        member.setUserName(memberRequest.getUserName());
        member.setAge(memberRequest.getAge());
        member.setTeam(team);

        memberRepository.save(member);
        return member.getId();
    }
}
