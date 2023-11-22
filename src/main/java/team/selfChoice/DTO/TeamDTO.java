package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class TeamDTO {
    private Long id;
    private String name;
    private ArrayList<PlayerDTO> players;
}
