package com.playground.jpa.member.service;

import com.playground.jpa.member.entity.Member;
import com.playground.jpa.member.entity.Team;
import com.playground.jpa.member.entity.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public List<Member> getMemberList(Long teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        return optionalTeam.map(Team::getMemberList).orElse(null);
    }
}
