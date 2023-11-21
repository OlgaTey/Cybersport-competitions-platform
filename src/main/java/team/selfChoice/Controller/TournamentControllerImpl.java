package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.Models.Tournament;

import java.util.ArrayList;

@RestController
public class TournamentControllerImpl implements TournamentController{
    @Override
    public void postTournament(Tournament tournament) {

    }

    @Override
    public Tournament getTournamentById(Long id) {
        return null;
    }

    @Override
    public void deleteTournamentById(Long id) {

    }

    @Override
    public void putTournamentById(Long id, Tournament tournament) {

    }

    @Override
    public ArrayList<Tournament> getLastTournaments(Integer pageSize, Integer pageNumber) {
        return null;
    }
}
