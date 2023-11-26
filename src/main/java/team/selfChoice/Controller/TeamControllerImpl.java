package team.selfChoice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.TeamDTO;
import team.selfChoice.DTO.create.TeamCreateDTO;
import team.selfChoice.Service.MainService;

@RestController
@AllArgsConstructor
public class TeamControllerImpl implements TeamController{

    @Autowired
    private final MainService teamService;
    @Override
    public void postTeam(TeamCreateDTO team) {
        teamService.createTeam(team);
    }

    @Override
    public TeamDTO getTeamById(Long id) {
        return teamService.getTeamDTOById(id);
    }

    @Override
    public void deleteTeamById(Long id) {
        teamService.deleteTeamById(id);
    }

    @Override
    public void putTeamById(Long id, TeamCreateDTO team) {
        teamService.updateTeamById(id, team);
    }
}
