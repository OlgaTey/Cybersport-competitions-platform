package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.*;
import team.selfChoice.Models.Player;
import team.selfChoice.Models.Tournament;
import team.selfChoice.Models.TournamentInfo;

import java.util.ArrayList;

@RestController
public interface TournamentController {

    @PostMapping("/tournament")
    public void postTournament(@RequestBody Tournament tournament);

    @GetMapping("/tournament/{id}")
    public Tournament getTournamentById(@PathVariable Long id);

    @DeleteMapping("/tournament/{id}")
    public void deleteTournamentById(@PathVariable Long id);

    @PutMapping("/tournament/{id}")
    public void putTournamentById(@PathVariable Long id, @RequestBody Tournament tournament);

    @GetMapping("/tournaments")
    public ArrayList<Tournament> getLastTournaments(@RequestParam(required = false, defaultValue = "5") Integer pageSize, @RequestParam(required = false, defaultValue = "1") Integer pageNumber);

}
