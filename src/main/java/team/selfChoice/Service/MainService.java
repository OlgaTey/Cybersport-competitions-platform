package team.selfChoice.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.selfChoice.DTO.*;
import team.selfChoice.Entity.*;
import team.selfChoice.Errors.NotFoundException;
import team.selfChoice.repository.*;

import java.util.ArrayList;
import java.util.Map;

@Service
public class MainService {

    @Autowired
    private AbsoluteTeamRepo absoluteTeamRepo;

    @Autowired
    private DisciplineRepo disciplineRepo;

    @Autowired
    private MatchRepo matchRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private RefereeRepo refereeRepo;

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private TournamentRepo tournamentRepo;


    public Match getMatchById(Long id) {
        return matchRepo.findById(id).orElseThrow(() -> new NotFoundException("Match with id = " + id + " is not found"));
    }

    public MatchDTO getMatchDTOById(Long id) {
        return null;
    }

    public void updateMatchById(Long id, MatchDTO matchDTO) {

    }

    public Map getResultByMatchId(Long id) {
        return null;
    }

    public void setResultByMatchId(Long id, Map result) {

    }

    public void createMatch(TournamentDTO tournamentDTO, ArrayList<TeamDTO> teams) {

    }

    public Profile getProfileById(Long id) {
        return null;
    }

    public ProfileDTO getProfileDTOById(Long id) {
        return null;
    }

    public void createProfile(ProfileDTO profile) {

    }

    public void updateProfileById(Long id, ProfileDTO profile) {

    }

    public void deleteProfileById(Long id) {

    }

    public Team getTeamById(Long id) {
        return null;
    }

    public TeamDTO getTeamDTOById(Long id) {
        return null;
    }

    public AbsoluteTeam getAbsoluteTeamById(Long id) {
        return null;
    }

    public AbsoluteTeamDTO getAbsoluteTeamDTOById(Long id) {
        return null;
    }

    public void createTeam(TeamDTO teamDTO) {

    }

    public void updateTeamById(Long id, TeamDTO team) {

    }

    public void deleteTeamById(Long id) {

    }

    public TournamentDTO getTournamentDTOById(Long id) {
        return null;
    }

    public Tournament getTournamentById(Long id) {
        return null;
    }

    public void createTournament(TournamentDTO tournament) {

    }

    public void updateTournamentById(Long id, TournamentDTO tournament) {

    }

    public void deleteTournamentById(Long id) {

    }

    public void addTeamByTournamentId(Long tournamentId, TeamDTO tournament) {

    }

    public void changeManagerByTournamentId(Long tournamentId, Long managerId) {

    }

    public void addJudgeByTournamentId(Long tournamentId, Long judgeId) {

    }

    public ArrayList<TeamDTO> getTeamsByTournamentId(Long tournamentId) {
        return null;
    }

    public ArrayList<TournamentDTO> getTournaments(Integer pageSize, Integer pageNumber) {
        return null;
    }

    public void ShuffleTeams(Long tournamentId, String shuffleType) {

    }

    public Referee getRefereeById(Long id) {
        return null;
    }

    public RefereeDTO getRefereeDTOById(Long id) {
        return null;
    }
}