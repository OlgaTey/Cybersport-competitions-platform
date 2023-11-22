package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.TeamDTO;

@RestController
public class TeamControllerImpl implements TeamController{
    @Override
    public void postTeam(TeamDTO teamDTO) {

    }

    @Override
    public TeamDTO getTeamById(Long id) {
        return null;
    }

    @Override
    public void deleteTeamById(Long id) {

    }

    @Override
    public void putTeamById(Long id, TeamDTO teamDTO) {

    }
}
