package team.selfChoice.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import team.selfChoice.DTO.TeamDTO;
import team.selfChoice.DTO.TournamentDTO;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TournamentService {
    public TournamentDTO getTournamentById(Long id) {
        return null;
    }
    public void createTournament(TournamentDTO tournament) {

    }
    public void updateTournamentById(Long id, TournamentDTO tournament) {

    }
    public void deleteTournamentById(Long id) {

    }
    public void addTeamByTournamentId(Long tournamentId, TeamDTO tournament) {

    }
    public void changeManagerByTournamentId(Long tournamentId, Long managerId) {

    }
    public void addJudgeByTournamentId(Long tournamentId, Long judgeId) {

    }
    public ArrayList<TeamDTO> getTeamsByTournamentId(Long tournamentId) {
        return null;
    }
    public ArrayList<TournamentDTO> getTournaments(Integer pageSize, Integer pageNumber) {
        return null;
    }

    public void ShuffleTeams(Long tournamentId, String shuffleType) {

    }
}
