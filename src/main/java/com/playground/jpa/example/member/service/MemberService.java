package com.playground.jpa.member.service;

import com.playground.jpa.member.entity.*;
import com.playground.jpa.member.model.request.MemberRequest;
import com.playground.jpa.member.model.request.ProductRequest;
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
    private final ProductRepository productRepository;
    private final OrdersRepository ordersRepository;

    public List<Member> getMemberList(){
        return memberRepository.findAll();
    }

    public Member getMember(Long memberId) {
        Optional<Member> memberOptional = memberRepository.findById(memberId);
//        memberOptional.ifPresent(member -> {
//            System.out.println("userName : " + member.getUserName());
//            // fetch = FetchType.LAZY 로 설정했을 때 아래 쿼리를 호출했을 때 비로소 데이터를 조회한다.
//            System.out.println("teamName : " + member.getTeam().getName());
//        });

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

    public Orders getOrders(Long memberId, Long productId) {
        return ordersRepository.findByMemberIdAndMemberId(memberId, productId);
    }

    public void addProducts(Long memberId, ProductRequest productRequest) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();

            // 상품 저장
            Product product = new Product();
            product.setName(productRequest.getName());
            productRepository.save(product);

            Orders orders = new Orders(member, product);
            ordersRepository.save(orders);
        }
    }
}
