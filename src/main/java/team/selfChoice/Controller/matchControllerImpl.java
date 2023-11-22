package team.selfChoice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.MatchDTO;
import team.selfChoice.Service.MatchService;

import java.util.Map;

@RestController
@AllArgsConstructor
public class matchControllerImpl implements matchController{

    @Autowired
    private final MatchService matchService;
    @Override
    public MatchDTO getMatch(Long id) {
        return matchService.getMatchById(id);
    }

    @Override
    public void putMatchById(Long id, MatchDTO match) {
        matchService.updateMatchById(id, match);
    }

    @Override
    public Map getResultByMatchById(Long id) {
        return matchService.getResultByMatchId(id);
    }

    @Override
    public void putResultByMatchById(Long id, Map result) {
        matchService.setResultByMatchId(id, result);

    }
}
