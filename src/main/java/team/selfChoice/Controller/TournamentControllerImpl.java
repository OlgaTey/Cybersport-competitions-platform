package team.selfChoice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.TeamDTO;
import team.selfChoice.DTO.TournamentDTO;
import team.selfChoice.DTO.create.TeamCreateDTO;
import team.selfChoice.DTO.create.TournamentCreateDTO;
import team.selfChoice.Service.MainService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TournamentControllerImpl implements TournamentController{

    @Autowired
    private final MainService tournamentService;
    @Override
    public void postTournament(TournamentCreateDTO tournamentDTO) {
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
    public void putTournamentById(Long tournamentId, TournamentCreateDTO tournament) {
        tournamentService.updateTournamentById(tournamentId, tournament);
    }

    @Override
    public void addTeamByTournamentId(Long tournamentId, TeamCreateDTO team) {
        tournamentService.addTeamByTournamentId(tournamentId, team);
    }

    @Override
    public void putManagerByTournamentId(Long tournamentId, Long managerId) {
        tournamentService.changeManagerByTournamentId(tournamentId, managerId);
    }

    @Override
    public void addJudgeByTournamentId(Long tournamentId, Long judgeId) {
        tournamentService.addRefereeByTournamentId(tournamentId, judgeId);
    }

    @Override
    public List<TeamDTO> getTeamsByTournamentId(Long tournamentId) {
        return tournamentService.getTeamsByTournamentId(tournamentId);
    }

    @Override
    public List<TournamentDTO> getLastTournaments(Integer pageSize, Integer pageNumber) {
        return tournamentService.getTournaments(pageSize, pageNumber);
    }
}
