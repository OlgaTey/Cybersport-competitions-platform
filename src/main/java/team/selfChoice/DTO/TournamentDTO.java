package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class TournamentDTO {
    private Long id;
    private List<Long> matchesId;
    private ManagerDTO manager;
    private List<Long> teamsId;
    private List<Long> refereesId;
    private TournamentInfoDTO info;
}
