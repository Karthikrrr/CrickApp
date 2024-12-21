package com.cricBlog.cricBlog.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cricBlog.cricBlog.DTO.TeamDto;
import com.cricBlog.cricBlog.Service.TeamService;

@Controller
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("/")
    public String TeamView(Model model){
        TeamDto teamDto = new TeamDto();
        model.addAttribute("teamDto", teamDto);
        return "indexForm";
    }
    
    @PostMapping("/")
    public String savePlayer(@ModelAttribute("teamDto") TeamDto teamDto, Model model){
        boolean isTrue = true;
        if(isTrue){
            model.addAttribute("success","Registered Successfull!!");
        }
        teamService.saveTeam(teamDto);
        return "indexForm";
    }

    @GetMapping("/getPlayersData")
    public String getAllPlayers(){
        return "playerView";
    }
}
