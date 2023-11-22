package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.*;
import team.selfChoice.DTO.TeamDTO;

@RestController
public interface TeamController {

    @PostMapping("/team")
    public void postTeam(@RequestBody TeamDTO teamDTO);

    @GetMapping("/team/{id}")
    public TeamDTO getTeamById(@PathVariable Long id);

    @DeleteMapping("/team/{id}")
    public void deleteTeamById(@PathVariable Long id);

    @PutMapping("/team/{id}")
    public void putTeamById(@PathVariable Long id, @RequestBody TeamDTO teamDTO);

}
