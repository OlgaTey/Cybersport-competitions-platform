package team.selfChoice.Shuffler;

import team.selfChoice.Entity.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shuffler {
    public static List<List<Team>> shuffleByMatchSize(List<Team> teams, int matchSize) {
        Random rand = new Random();
        List<List<Team>> result = new ArrayList<>();
        for (int i = 0; i < teams.size(); i+=matchSize) {
            List<Team> temp =  new ArrayList<>();
            for (int j = 0; j < matchSize; j++) {
                temp.add(teams.remove(rand.nextInt(teams.size())));
            }
            result.add(temp);
        }
        return result;
    }
    public static List<List<Team>> shuffleByMatchCount(List<Team> teams, int matchCount) {
        int matchSize = teams.size() / matchCount;
        Random rand = new Random();
        List<List<Team>> result = new ArrayList<>();
        for (int i = 0; i < teams.size(); i+=matchSize) {
            List<Team> temp =  new ArrayList<>();
            for (int j = 0; j < matchSize; j++) {
                temp.add(teams.remove(rand.nextInt(teams.size())));
            }
            result.add(temp);
        }
        return result;
    }
}
