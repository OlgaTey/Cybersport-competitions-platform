package team.selfChoice.Controller;

import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;
import team.selfChoice.DTO.MatchDTO;
import team.selfChoice.DTO.create.MatchCreateDTO;

import java.util.Map;

@RestController
public interface matchController {

    @GetMapping("/match/{matchId}")
    public MatchDTO getMatch(@PathVariable @Min(1) Long matchId);
    @PutMapping("/match/{matchId}")
    public void putMatchById(@PathVariable @Min(1) Long matchId, @RequestBody MatchCreateDTO matchDTO);
    @GetMapping("/match/{matchId}/result")
    public Map getResultByMatchById(@PathVariable @Min(1) Long matchId);
    @PutMapping("/match/{matchId}/result")
    public void putResultByMatchById(@PathVariable @Min(1) Long matchId, @RequestBody Map<String, Double> result);
}
