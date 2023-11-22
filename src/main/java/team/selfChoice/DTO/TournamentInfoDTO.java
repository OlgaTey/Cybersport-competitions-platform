package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TournamentInfoDTO {
    private String name;
    private String description;
    private String start_date;
    private String finish_date;
    private DisciplineDTO discipline;
    private String start_registration;
    private String end_registration;
    private int prize_pool;
    private String location;
}
