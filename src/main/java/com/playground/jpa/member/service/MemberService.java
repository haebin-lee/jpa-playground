package com.playground.jpa.member.service;

import com.playground.jpa.member.entity.Member;
import com.playground.jpa.member.entity.MemberRepository;
import com.playground.jpa.member.entity.Team;
import com.playground.jpa.member.entity.TeamRepository;
import com.playground.jpa.member.model.request.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        return memberOptional.orElse(null);
    }

    public Long addMember(MemberRequest memberRequest) {

        Team team = teamRepository.findByName(memberRequest.getTeamName());

        Member member = new Member();
        member.setUserName(memberRequest.getUserName());
        member.setAge(memberRequest.getAge());
        member.setTeam(Optional.ofNullable(team).orElseGet(() -> new Team(memberRequest.getTeamName())));

        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public void updateMemberTeam(Long memberId, String userName, String teamName) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        memberOptional.ifPresent(member -> {
           member.updateUserNameAndTeamName(userName, teamName);
        });
    }

    @Transactional
    public void deleteTeamFromMember(Long memberId) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        memberOptional.ifPresent(member -> {
            member.setTeam(null);
        });
    }
}
