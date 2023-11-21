package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.*;
import team.selfChoice.Models.Match;
import team.selfChoice.Models.Profile;

@RestController
public interface matchController {

    @PostMapping("/match")
    public void postMatch(@RequestBody Match match);

    @PutMapping("/match/{id}")
    public void putMatchById(@PathVariable Long id, @RequestBody Match match);
}
