package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class TeamDTO {
    private Long id;
    private String name;
    private List<PlayerDTO> players;
    private Long captainId;
    private List<MatchDTO> matches;
    private Integer position;
    private Map<String, Double> points;
    private Long tournamentId;
}
