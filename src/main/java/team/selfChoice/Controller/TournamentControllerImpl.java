package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.JudgeDTO;
import team.selfChoice.DTO.ManagerDTO;
import team.selfChoice.DTO.TeamDTO;
import team.selfChoice.DTO.TournamentDTO;

import java.util.ArrayList;

@RestController
public class TournamentControllerImpl implements TournamentController{
    @Override
    public void postTournament(TournamentDTO tournamentDTO) {

    }

    @Override
    public TournamentDTO getTournamentById(Long id) {
        return null;
    }

    @Override
    public void deleteTournamentById(Long id) {

    }

    @Override
    public void putTournamentById(Long id, TournamentDTO tournament) {

    }

    @Override
    public void putManagerByTournamentId(Long tournamentId, ManagerDTO manager) {

    }

    @Override
    public void addJudgeByTournamentId(Long tournamentId, JudgeDTO judge) {

    }

    @Override
    public ArrayList<TeamDTO> getTeamsByTournamentId(Long tournamentId) {
        return null;
    }

    @Override
    public ArrayList<TournamentDTO> getLastTournaments(Integer pageSize, Integer pageNumber) {
        return null;
    }
}
