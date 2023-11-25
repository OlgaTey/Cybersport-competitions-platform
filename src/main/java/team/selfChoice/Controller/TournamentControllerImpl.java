package team.selfChoice.Controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.TeamDTO;
import team.selfChoice.DTO.TournamentDTO;
import team.selfChoice.Entity.*;
import team.selfChoice.Exporter.ExcelFileExporter;
import team.selfChoice.Service.ExportService;
import team.selfChoice.Service.MainService;
import team.selfChoice.Service.MainService.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;


@RestController
@AllArgsConstructor
public class TournamentControllerImpl implements TournamentController{

    @Autowired
    private final MainService tournamentService;
    @Autowired
    private final ExportService exportService;
    @Override
    public void postTournament(TournamentDTO tournamentDTO) {
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
    public void putTournamentById(Long tournamentId, TournamentDTO tournament) {
        tournamentService.updateTournamentById(tournamentId, tournament);
    }

    @Override
    public void addTeamByTournamentId(Long tournamentId, TeamDTO team) {
        tournamentService.addTeamByTournamentId(tournamentId, team);
    }

    @Override
    public void putManagerByTournamentId(Long tournamentId, Long managerId) {
        tournamentService.changeManagerByTournamentId(tournamentId, managerId);
    }

    @Override
    public void addJudgeByTournamentId(Long tournamentId, Long judgeId) {
        tournamentService.addJudgeByTournamentId(tournamentId, judgeId);
    }

    @Override
    public ArrayList<TeamDTO> getTeamsByTournamentId(Long tournamentId) {
        return tournamentService.getTeamsByTournamentId(tournamentId);
    }

    @Override
    public ArrayList<TournamentDTO> getLastTournaments(Integer pageSize, Integer pageNumber) {
        return tournamentService.getTournaments(pageSize, pageNumber);
    }

    @Override
    public void exportTournament(Long tournamentId, HttpServletResponse response) throws IOException {
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
        List<Player> ps = new ArrayList<Player>();
        teams.add(new Team(1L, "name", ps, 1L, new ArrayList<Match>(), 1, new HashMap<String, Double>(), t));
        ps.add(new Player(1L, "nick", 1L, teams.get(0), "ru"));
        ps.add(new Player(1L, "nick", 1L, teams.get(0), "ru"));
        ps.add(new Player(1L, "nick", 1L, teams.get(0), "ru"));
        t.setParticipants(teams);
        ByteArrayInputStream stream = exportService.TournamentExport(t);
        IOUtils.copy(stream, response.getOutputStream());
    }
}
