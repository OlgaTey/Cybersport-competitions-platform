package team.selfChoice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.TeamDTO;
import team.selfChoice.DTO.TournamentDTO;
import team.selfChoice.Service.MainService;

import java.util.ArrayList;

@RestController
@AllArgsConstructor
public class TournamentControllerImpl implements TournamentController{

    @Autowired
    private final MainService tournamentService;
    @Override
    public void postTournament(TournamentDTO tournamentDTO) {
        tournamentService.createTournament(tournamentDTO);
    }

    @Override
    public TournamentDTO getTournamentById(Long tournamentId) {
        return tournamentService.getTournamentDTOById(tournamentId);
    }

    @Override
    public void deleteTournamentById(Long tournamentId) {
        tournamentService.deleteTournamentById(tournamentId);
    }

    @Override
    public void putTournamentById(Long tournamentId, TournamentDTO tournament) {
        tournamentService.updateTournamentById(tournamentId, tournament);
    }

    @Override
    public void addTeamByTournamentId(Long tournamentId, TeamDTO team) {
        tournamentService.addTeamByTournamentId(tournamentId, team);
    }

    @Override
    public void putManagerByTournamentId(Long tournamentId, Long managerId) {
        tournamentService.changeManagerByTournamentId(tournamentId, managerId);
    }

    @Override
    public void addJudgeByTournamentId(Long tournamentId, Long judgeId) {
        tournamentService.addJudgeByTournamentId(tournamentId, judgeId);
    }

    @Override
    public ArrayList<TeamDTO> getTeamsByTournamentId(Long tournamentId) {
        return tournamentService.getTeamsByTournamentId(tournamentId);
    }

    @Override
    public ArrayList<TournamentDTO> getLastTournaments(Integer pageSize, Integer pageNumber) {
        return tournamentService.getTournaments(pageSize, pageNumber);
    }
}
