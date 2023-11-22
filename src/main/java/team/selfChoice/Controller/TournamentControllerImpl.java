package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.RestController;
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
    public void putTournamentById(Long id, TournamentDTO tournamentDTO) {

    }

    @Override
    public ArrayList<TournamentDTO> getLastTournaments(Integer pageSize, Integer pageNumber) {
        return null;
    }
}
