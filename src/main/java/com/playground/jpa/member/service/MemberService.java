package com.playground.jpa.member.service;

import com.playground.jpa.member.entity.*;
import com.playground.jpa.member.model.request.MemberRequest;
import com.playground.jpa.member.model.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final ProductRepository productRepository;

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
        Team team = new Team(teamName);
        teamRepository.save(team);

        memberOptional.ifPresent(member -> {
            member.setTeam(team);
            //member.updateUserNameAndTeamName(userName, teamName);
        });

        team.getMemberList().forEach(m -> System.out.println(m.getUserName()));

    }

    @Transactional
    public void deleteTeamFromMember(Long memberId) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
        memberOptional.ifPresent(member -> {
            member.setTeam(null);
        });
    }

    public List<Product> getProducts(Long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        return optionalMember.map(Member::getProducts).orElseGet(null);
    }
    @Transactional
    public void addProducts(Long memberId, ProductRequest productRequest) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        optionalMember.ifPresent(member -> {
            Product product = new Product();
            product.setName(productRequest.getName());
            member.getProducts().add(product);
        });
    }
}
