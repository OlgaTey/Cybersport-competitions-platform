package team.selfChoice.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import team.selfChoice.DTO.MatchDTO;
import team.selfChoice.DTO.TeamDTO;
import team.selfChoice.DTO.TournamentDTO;

import java.util.ArrayList;
import java.util.Map;

@Service
@AllArgsConstructor
public class MatchService {
    public MatchDTO getMatchById(Long id) {
        return null;
    }
    public void updateMatchById(Long id, MatchDTO matchDTO) {

    }
    public Map setResultByMatchId(Long id) {
        return null;
    }
    public void getResultByMatchId(Long id, MatchDTO matchDTO) {

    }
    public void createMatch(TournamentDTO tournamentDTO, ArrayList<TeamDTO> teams) {

    }

}