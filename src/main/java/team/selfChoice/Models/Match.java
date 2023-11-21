package team.selfChoice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;

@AllArgsConstructor
@Data
public class Match {
    private Long id;
    private ArrayList<Team> participants;
    private ArrayList<ResultPair> result;
    private String discipline;
    private ArrayList<Entity> data;

}
