package com.cricBlog.cricBlog.ServiceImplmentation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cricBlog.cricBlog.DTO.TeamDto;
import com.cricBlog.cricBlog.Models.Teams;
import com.cricBlog.cricBlog.Repository.TeamRepository;
import com.cricBlog.cricBlog.Service.TeamService;

@Service
public class TeamServiceImplementation implements TeamService{

    private final TeamRepository teamRepository;
    private static int counter = 1; 

    public TeamServiceImplementation(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    @Override
    public Teams saveTeam(TeamDto teamDto) {
        Teams team = new Teams();
        String id = generateNextId("KMS");
        team.setName(teamDto.getName());
        team.setPhoneNumber(teamDto.getPhoneNumber());
        team.setPlayerType(teamDto.getPlayerType());
        team.setAddress(teamDto.getAddress());
        team.setPlayerId(id);
        team.setCreatedAt(LocalDateTime.now());
        return teamRepository.save(team); 
    }

    public static String generateNextId(String prefix) {
        String formattedNumber = String.format("%04d", counter);
        String nextId = prefix + "-" + formattedNumber;
        counter++;
        return nextId;
    }

    @Override
    public List<Teams> getAllTeams() {
        return teamRepository.findAll();
    }

}
