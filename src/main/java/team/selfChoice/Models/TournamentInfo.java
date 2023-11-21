package team.selfChoice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TournamentInfo {
    private String name;
    private String start_date;
    private String finish_date;
    private String discipline;
    private int prize_pool;
}
