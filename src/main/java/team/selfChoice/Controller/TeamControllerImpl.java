package team.selfChoice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.TeamDTO;
import team.selfChoice.Service.TeamService;

@RestController
@AllArgsConstructor
public class TeamControllerImpl implements TeamController{

    @Autowired
    private final TeamService teamService;
    @Override
    public void postTeam(TeamDTO team) {
        teamService.createTeam(team);
    }

    @Override
    public TeamDTO getTeamById(Long id) {
        return teamService.getTeamById(id);
    }

    @Override
    public void deleteTeamById(Long id) {
        teamService.deleteTeamById(id);
    }

    @Override
    public void putTeamById(Long id, TeamDTO team) {
        teamService.updateTeamById(id, team);
    }
}
