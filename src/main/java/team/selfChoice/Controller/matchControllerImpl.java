package team.selfChoice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.MatchDTO;
import team.selfChoice.Service.MainService;

import java.util.Map;

@RestController
@AllArgsConstructor
public class matchControllerImpl implements matchController{

    @Autowired
    private final MainService mainService;
    @Override
    public MatchDTO getMatch(Long id) {
        return mainService.getMatchDTOById(id);
    }

    @Override
    public void putMatchById(Long id, MatchDTO match) {
        mainService.updateMatchById(id, match);
    }

    @Override
    public Map getResultByMatchById(Long id) {
        return mainService.getResultByMatchId(id);
    }

    @Override
    public void putResultByMatchById(Long id, Map result) {
        mainService.setResultByMatchId(id, result);

    }
}
