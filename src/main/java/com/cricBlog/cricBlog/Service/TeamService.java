package com.cricBlog.cricBlog.Service;

import java.util.List;

import com.cricBlog.cricBlog.DTO.TeamDto;
import com.cricBlog.cricBlog.Models.Teams;

public interface TeamService {

    Teams saveTeam(TeamDto teamDto);
    List<Teams> getAllTeams();
    
}
