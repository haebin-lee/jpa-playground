package com.playground.jpa.example.member.controller;


import com.playground.jpa.example.member.entity.Member;
import com.playground.jpa.example.member.entity.Orders;
import com.playground.jpa.example.member.model.request.MemberRequest;
import com.playground.jpa.example.member.model.request.ProductRequest;
import com.playground.jpa.example.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable Long memberId) {
        Member member = memberService.getMember(memberId);
        System.out.println("member : " + member);

        return ResponseEntity.ok(member);
//        memberService.getMember(memberId);
//        return ResponseEntity.ok().build();
    }

    @PostMapping("/member")
    public Long addMember(@RequestBody MemberRequest memberRequest) {
        return memberService.addMember(memberRequest);
    }

    @PutMapping("/member/{memberId}")
    public ResponseEntity<Void> updateMember(
            @PathVariable Long memberId,
            @RequestBody MemberRequest.UpdateMember updateMember) {
        memberService.updateMemberTeam(memberId, updateMember.getUserName(), updateMember.getTeamName());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/member/{memberId}/team")
    public ResponseEntity<Void> deleteTeamFromUser(
            @PathVariable Long memberId) {
        memberService.deleteTeamFromMember(memberId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/member/{memberId}/product/{productId}")
    public ResponseEntity<Orders> getProducts (
            @PathVariable Long memberId,
            @PathVariable Long productId) {
        return ResponseEntity.ok(memberService.getOrders(memberId, productId));
    }
    @PostMapping("/member/{memberId}/products")
    public ResponseEntity<Void> addProducts(
            @PathVariable Long memberId,
            @RequestBody ProductRequest productRequest) {
        memberService.addProducts(memberId, productRequest);
        return ResponseEntity.ok().build();
    }
}
