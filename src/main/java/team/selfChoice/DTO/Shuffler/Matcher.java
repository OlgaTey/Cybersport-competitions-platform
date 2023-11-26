package team.selfChoice.DTO.Shuffler;

import team.selfChoice.Entity.Match;
import team.selfChoice.Entity.Team;
import team.selfChoice.Entity.Tournament;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Matcher {
    public static List<Match> createMatches(Tournament t, int matchSize) {
        List<List<Team>> groups = Shuffler.shuffleByMatchSize(t.getParticipants(), matchSize);
        List<Match> matches = new LinkedList<>();
        for (int i = 0; i < groups.size(); i++) {
            for (int j = 0; j < groups.get(i).size(); j++) {
                List<Team> teams = new LinkedList<Team>();
                teams.add(groups.get(i).get(j));
                Match match = new Match(t);
                match.setParticipants(teams);
                matches.add(match);
            }
        }
        t.setMatches(matches);
        return matches;
    }
}
