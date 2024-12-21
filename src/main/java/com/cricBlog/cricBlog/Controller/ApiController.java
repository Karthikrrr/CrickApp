package com.cricBlog.cricBlog.Controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cricBlog.cricBlog.Models.Teams;
import com.cricBlog.cricBlog.Service.TeamService;

@RestController
public class ApiController {

    private final TeamService teamService;

    public ApiController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("/getJsonData")
    @ResponseBody
    public List<Teams> getAllPlayers(Model model){
        List<Teams> player = teamService.getAllTeams();
        return player;
    }
}
