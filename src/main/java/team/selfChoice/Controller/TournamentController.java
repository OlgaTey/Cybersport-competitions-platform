package team.selfChoice.Controller;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;
import team.selfChoice.DTO.TeamDTO;
import team.selfChoice.DTO.TournamentDTO;
import team.selfChoice.DTO.create.RefereeAddingDTO;
import team.selfChoice.DTO.create.TeamCreateDTO;
import team.selfChoice.DTO.create.TournamentCreateDTO;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public interface TournamentController {

    @PostMapping("/tournament")
    public void postTournament(@RequestBody TournamentCreateDTO tournament);

    @GetMapping("/tournament/{tournamentId}")
    public TournamentDTO getTournamentById(@PathVariable @Min(1) Long tournamentId);

    @DeleteMapping("/tournament/{tournamentId}")
    public void deleteTournamentById(@PathVariable @Min(1) Long tournamentId);

    @PutMapping("/tournament/{tournamentId}")
    public void putTournamentById(@PathVariable @Min(1) Long tournamentId, @RequestBody TournamentCreateDTO tournament);
    @GetMapping("/tournament/{tournamentId}/addTeam")
    public void addTeamByTournamentId(@PathVariable @Min(1) Long tournamentId, TeamCreateDTO team);

    @PutMapping("/tournament/{tournamentId}/changeManager")
    public void putManagerByTournamentId(@PathVariable @Min(1) Long tournamentId, @RequestBody Long managerId);

    @PostMapping("/tournament/{tournamentId}/addJudge")
    public void addJudgeByTournamentId(@PathVariable @Min(1) Long tournamentId, @RequestBody RefereeAddingDTO dto);
    @GetMapping("/tournament/{tournamentId}/teams")
    public List<TeamDTO> getTeamsByTournamentId(@PathVariable @Min(1) Long tournamentId);
    @GetMapping("/tournaments")
    public List<TournamentDTO> getLastTournaments();
    @GetMapping("/t/{tournamentId}")
    public void exportTournament(@PathVariable Long tournamentId, HttpServletResponse response) throws IOException;
}