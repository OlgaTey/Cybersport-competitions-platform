package team.selfChoice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@Data
public class Team {
    private Long id;
    private String name;
    private ArrayList<Player> players;
}
