package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.*;
import team.selfChoice.Models.Profile;
import team.selfChoice.Models.Team;

@RestController
public interface TeamController {

    @PostMapping("/team")
    public void postTeam(@RequestBody Team team);

    @GetMapping("/team/{id}")
    public Team getTeamById(@PathVariable Long id);

    @DeleteMapping("/team/{id}")
    public void deleteTeamById(@PathVariable Long id);

    @PutMapping("/team/{id}")
    public void putTeamById(@PathVariable Long id, @RequestBody Team team);

}
