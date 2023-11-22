package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class TournamentDTO {
    private Long id;
    private String manager;
    private ArrayList<TeamDTO> teams;
    private ArrayList<JudgeDTO> judges;
    private TournamentInfoDTO info;
}
