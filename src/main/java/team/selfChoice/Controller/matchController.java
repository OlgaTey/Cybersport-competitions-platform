package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.*;
import team.selfChoice.DTO.MatchDTO;

@RestController
public interface matchController {

    @PostMapping("/matchDTO")
    public void postMatch(@RequestBody MatchDTO matchDTO);

    @PutMapping("/matchDTO/{id}")
    public void putMatchById(@PathVariable Long id, @RequestBody MatchDTO matchDTO);
}
