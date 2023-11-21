package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.Models.Team;

@RestController
public class TeamControllerImpl implements TeamController{
    @Override
    public void postTeam(Team team) {

    }

    @Override
    public Team getTeamById(Long id) {
        return null;
    }

    @Override
    public void deleteTeamById(Long id) {

    }

    @Override
    public void putTeamById(Long id, Team team) {

    }
}
