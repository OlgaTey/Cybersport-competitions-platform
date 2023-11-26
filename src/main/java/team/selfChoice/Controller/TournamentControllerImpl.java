package team.selfChoice.Controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.TeamDTO;
import team.selfChoice.DTO.TournamentDTO;
import team.selfChoice.DTO.create.RefereeAddingDTO;
import team.selfChoice.DTO.create.TeamCreateDTO;
import team.selfChoice.DTO.create.TournamentCreateDTO;
import team.selfChoice.Entity.*;
import team.selfChoice.Service.ExportService;
import team.selfChoice.Service.MainService;
import team.selfChoice.Service.MainService.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TournamentControllerImpl implements TournamentController{

    @Autowired
    private final MainService tournamentService;
    @Autowired
    private final ExportService exportService;
    @Override
    public void postTournament(TournamentCreateDTO tournamentDTO) {
        tournamentService.createTournament(tournamentDTO);
    }

    @Override
    public TournamentDTO getTournamentById(Long tournamentId) {
        return tournamentService.getTournamentDTOById(tournamentId);
    }

    @Override
    public void deleteTournamentById(Long tournamentId) {
        tournamentService.deleteTournamentById(tournamentId);
    }

    @Override
    public void putTournamentById(Long tournamentId, TournamentCreateDTO tournament) {
        tournamentService.updateTournamentById(tournamentId, tournament);
    }

    @Override
    public void addTeamByTournamentId(Long tournamentId, TeamCreateDTO team) {
        tournamentService.addTeamByTournamentId(tournamentId, team);
    }

    @Override
    public void putManagerByTournamentId(Long tournamentId, Long managerId) {
        tournamentService.changeManagerByTournamentId(tournamentId, managerId);
    }

    @Override
    public void addJudgeByTournamentId(Long tournamentId, RefereeAddingDTO dto) {
        tournamentService.addRefereeByTournamentId(tournamentId, dto);
    }

    @Override
    public List<TeamDTO> getTeamsByTournamentId(Long tournamentId) {
        return tournamentService.getTeamsByTournamentId(tournamentId);
    }

    @Override
    public List<TournamentDTO> getLastTournaments() {
        return tournamentService.getTournaments();
    }

    @Override
    public List<TournamentDTO> getLastFIlteredTournaments(Boolean isOfficial) {
        return tournamentService.getTournaments(isOfficial);
    }

    @Override
    public void exportTournament(Long tournamentId, HttpServletResponse response) throws IOException {

        ByteArrayInputStream stream = exportService.TournamentExport(tournamentService.getTournamentById(tournamentId));
    }

    @Override
    public void exportTournament(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=tournament.xlsx");
        Tournament t = new Tournament();
        t.setName("Название");
        t.setDiscipline(new Discipline(1L, "disc", new ArrayList<Tournament>()));
        t.setStartDate(new Date());
        t.setEndDate(new Date());
        t.setStartRegistration(new Date());
        t.setEndRegistration(new Date());
        t.setDescription("info");
        t.setDescription("ru");
        t.setManager(new Manager("name", 1L));
        ArrayList<Referee> refs = new ArrayList<Referee>();
        refs.add(new Referee(1L, "nick", "post", 1, "ru", "Samara", t, 1L));
        t.setReferees(refs);
        List<Team> teams = new ArrayList<Team>();
        for (Integer i = 1; i < 9; i++) {
            List<Player> ps = new ArrayList<Player>();
            teams.add(new Team(i.longValue(), String.format("team_%s", i), ps, i.longValue()*3, new ArrayList<Match>(), 9-i, new HashMap<String, Double>(), t));
            ps.add(new Player(i.longValue()*3, String.format("name_%s", 3*i), i.longValue()*3, teams.get(i-1), "ru"));
            ps.add(new Player(i.longValue()*3+1, String.format("name_%s", 3*i+1), i.longValue()*3+1, teams.get(i-1), "ru"));
            ps.add(new Player(i.longValue()*3+2, String.format("name_%s", 3*i+2), i.longValue()*3+2, teams.get(i-1), "ru"));
        }
        t.setParticipants(teams);
        List<Match> matches = new ArrayList<Match>();
        for (Integer i = 0; i < 4; i++) {
            List<Team> teams_temp = new ArrayList<Team>();
            teams_temp.add(teams.get(i*2));
            teams_temp.add(teams.get(i*2+1));
            Match match = new Match();
            match.setParticipants(teams_temp);
            match.setTournament(t);
            matches.add(match);
        }
        for (int i = 0; i < 2; i++) {
            List<Team> teams_temp = new ArrayList<Team>();
            teams_temp.add(matches.get(i*2).getParticipants().get(1));
            teams_temp.add(matches.get(i*2+1).getParticipants().get(1));
            Match match = new Match();
            match.setParticipants(teams_temp);
            match.setTournament(t);
            matches.add(match);
        }
        List<Team> teams_temp = new ArrayList<Team>();
        teams_temp.add(matches.get(4).getParticipants().get(1));
        teams_temp.add(matches.get(5).getParticipants().get(1));
        Match match = new Match();
        match.setParticipants(teams_temp);
        match.setTournament(t);
        matches.add(match);


        t.setMatches(matches);

        ByteArrayInputStream stream = exportService.TournamentExport(t);
        IOUtils.copy(stream, response.getOutputStream());
    }
}