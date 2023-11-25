package team.selfChoice.Controller;

import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;
import team.selfChoice.DTO.TeamDTO;

@RestController
public interface TeamController {

    @PostMapping("/team")
    public void postTeam(@RequestBody TeamDTO teamDTO);

    @GetMapping("/team/{id}")
    public TeamDTO getTeamById(@PathVariable @Min(1) Long id);

    @DeleteMapping("/team/{id}")
    public void deleteTeamById(@PathVariable @Min(1) Long id);

    @PutMapping("/team/{id}")
    public void putTeamById(@PathVariable @Min(1) Long id, @RequestBody TeamDTO teamDTO);

}
