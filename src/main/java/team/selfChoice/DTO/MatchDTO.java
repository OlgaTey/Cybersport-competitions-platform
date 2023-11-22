package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Map;

@AllArgsConstructor
@Data
public class MatchDTO {
    private Long id;
    private ArrayList<TeamDTO> participants;
    private Map result;
    private String discipline;
    private ArrayList<Entity> data;

}
