package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.*;
import team.selfChoice.DTO.TournamentDTO;

import java.util.ArrayList;

@RestController
public interface TournamentController {

    @PostMapping("/tournamentDTO")
    public void postTournament(@RequestBody TournamentDTO tournamentDTO);

    @GetMapping("/tournament/{id}")
    public TournamentDTO getTournamentById(@PathVariable Long id);

    @DeleteMapping("/tournament/{id}")
    public void deleteTournamentById(@PathVariable Long id);

    @PutMapping("/tournamentDTO/{id}")
    public void putTournamentById(@PathVariable Long id, @RequestBody TournamentDTO tournamentDTO);

    @GetMapping("/tournaments")
    public ArrayList<TournamentDTO> getLastTournaments(@RequestParam(required = false, defaultValue = "5") Integer pageSize, @RequestParam(required = false, defaultValue = "1") Integer pageNumber);

}
