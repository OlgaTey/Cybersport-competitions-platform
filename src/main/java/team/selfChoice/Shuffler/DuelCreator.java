package team.selfChoice.Shuffler;

import team.selfChoice.Entity.Duel;
import team.selfChoice.Entity.Match;
import team.selfChoice.Entity.Team;
import team.selfChoice.Entity.Tournament;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DuelCreator {

    public static void createDuels(Match match, int duelsForTeam) {
        List<Duel> duels = new LinkedList<>();
        List<Team> teams = match.getParticipants();
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i+1; j < teams.size(); j++) {
                Duel duel = new Duel();
                duel.setTeam1(teams.get(i));
                duel.setTeam1(teams.get(j));
            }
        }
        match.setDuels(duels);
        return duels;
    }
}
