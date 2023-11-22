package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.*;
import team.selfChoice.DTO.MatchDTO;

import java.util.Map;

@RestController
public interface matchController {

    @GetMapping("/match/{matchId}")
    public MatchDTO getMatch(@PathVariable Long id);
    @PutMapping("/match/{matchId}")
    public void putMatchById(@PathVariable Long id, @RequestBody MatchDTO matchDTO);
    @GetMapping("/match/{matchId}/result")
    public Map getResultByMatchById(@PathVariable Long id);
    @PutMapping("/match/{matchId}/result")
    public void putResultByMatchById(@PathVariable Long id, @RequestBody Map result);
}
