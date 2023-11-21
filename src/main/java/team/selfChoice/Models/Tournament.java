package team.selfChoice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.Map;

@AllArgsConstructor
@Data
public class Tournament {
    private Long id;
    private TournamentInfo info;
}
