package com.playground.jpa.member.controller;

import com.playground.jpa.member.entity.Member;
import com.playground.jpa.member.entity.Product;
import com.playground.jpa.member.model.request.MemberRequest;
import com.playground.jpa.member.model.request.ProductRequest;
import com.playground.jpa.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMember(memberId));
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

    @GetMapping("/member/{memberId}/products")
    public ResponseEntity<List<Product>> getProducts (
            @PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getProducts(memberId));
    }
    @PostMapping("/member/{memberId}/products")
    public ResponseEntity<Void> addProducts(
            @PathVariable Long memberId,
            @RequestBody ProductRequest productRequest) {
        memberService.addProducts(memberId, productRequest);
        return ResponseEntity.ok().build();
    }
}
