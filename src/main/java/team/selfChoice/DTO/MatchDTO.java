package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class MatchDTO {
    private Long id;
    private List<Long> participants;
//    private Map result;
    private Long tournamentId;
}
