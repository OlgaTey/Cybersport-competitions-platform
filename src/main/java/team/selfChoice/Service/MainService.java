package team.selfChoice.Service;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.selfChoice.DTO.*;
import team.selfChoice.DTO.create.MatchCreateDTO;
import team.selfChoice.DTO.create.ProfileCreateDTO;
import team.selfChoice.DTO.create.TeamCreateDTO;
import team.selfChoice.DTO.create.TournamentCreateDTO;
import team.selfChoice.Entity.*;
import team.selfChoice.Errors.NotFoundException;
import team.selfChoice.mapper.EntitiesMapper;
import team.selfChoice.repository.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.Math.min;

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
        return matchRepo.findById(id).orElseThrow(()
                ->
                new NotFoundException("Match with id = " + id + " is not found"));
    }

    public MatchDTO getMatchDTOById(Long id) {
        return EntitiesMapper.matchToDTO(getMatchById(id));
    }

    public void updateMatchById(Long id, MatchCreateDTO matchDTO) {
        Match match = getMatchById(id);

        matchRepo.save(EntitiesMapper.updateMatch(matchDTO, match));
    }

    public Map<String, Double> getResultByTeamId(Long id) {
        return getTeamById(id).getPoints();
    }

    public void setResultByTeamId(Long id, Map<String, Double> result) {
        Team team = getTeamById(id);
        team.setPoints(result);
        teamRepo.save(team);
    }

    public void createMatch(MatchCreateDTO dto) {
        Match match = EntitiesMapper.DTOToMatch(dto);

        matchRepo.save(match);
    }

    public Profile getProfileById(Long id) {
        return profileRepo.findById(id).orElseThrow(()
                ->
                new NotFoundException("Profile with id = " + id + " is not found"));
    }

    public ProfileDTO getProfileDTOById(Long id) {
        return EntitiesMapper.profileToDTO(getProfileById(id));
    }

    public void createProfile(ProfileCreateDTO dto) {
        Profile profile = EntitiesMapper.DTOToProfile(dto);

        profileRepo.save(profile);
    }

    public void updateProfileById(Long id, ProfileCreateDTO profileDTO) {
        Profile profile = getProfileById(id);

        profileRepo.save(EntitiesMapper.updateProfile(profileDTO, profile));
    }

    public void deleteProfileById(Long id) {
        profileRepo.deleteById(id);
    }

    public void makeProfileOfficial(Long profileId) {
        getProfileById(profileId).setIsOfficialReferee(true);
    }

    public Team getTeamById(Long id) {
        return teamRepo.findById(id).orElseThrow(()
                ->
                new NotFoundException("Team with id = " + id + " is not found"));
    }

    public TeamDTO getTeamDTOById(Long id) {
        return EntitiesMapper.teamToDTO(getTeamById(id));
    }

    public AbsoluteTeam getAbsoluteTeamById(Long id) {
        return absoluteTeamRepo.findById(id).orElseThrow(()
                -> new
                NotFoundException("AbsoluteTeam with id = " + id + " is not found"));
    }

    public AbsoluteTeamDTO getAbsoluteTeamDTOById(Long id) {
        return EntitiesMapper.absoluteTeamToDTO(getAbsoluteTeamById(id));
    }

    public void createTeam(TeamCreateDTO teamDTO) {
        teamRepo.save(EntitiesMapper.DTOToTeam(teamDTO));
    }

    public void updateTeamById(Long id, TeamCreateDTO teamDTO) {
        Team team = getTeamById(id);

        teamRepo.save(EntitiesMapper.updateTeam(teamDTO, team));
    }

    public void deleteTeamById(Long id) {
        teamRepo.deleteById(id);
    }

    public TournamentDTO getTournamentDTOById(Long id) {
        return EntitiesMapper.tournamentToDTO(getTournamentById(id));
    }

    public Tournament getTournamentById(Long id) {
        return tournamentRepo.findById(id).orElseThrow(()
                ->
                new NotFoundException("Tournament with id = " + id + " is not found"));
    }

    public void createTournament(TournamentCreateDTO tournamentDTO) {
        tournamentRepo.save(EntitiesMapper.DTOToTournament(tournamentDTO));
    }

    public void updateTournamentById(Long id, TournamentCreateDTO tournamentDTO) {
        Tournament tournament = getTournamentById(id);

        tournamentRepo.save(EntitiesMapper.updateTournament(tournamentDTO, tournament));
    }

    public void deleteTournamentById(Long id) {
        tournamentRepo.deleteById(id);
    }

    public void addTeamByTournamentId(Long tournamentId, TeamCreateDTO teamDTO) {
        Team team = EntitiesMapper.DTOToTeam(teamDTO);
        Tournament tournament = getTournamentById(tournamentId);

        team.setTournament(tournament);
        tournament.getParticipants().add(team);

        teamRepo.save(team);
        tournamentRepo.save(tournament);
    }

    public void changeManagerByTournamentId(Long tournamentId, Long managerId) {
        Tournament tournament = getTournamentById(tournamentId);
        Referee manager = getRefereeById(managerId);

        tournament.getManager().setChiefRefereeId(managerId);
        tournament.getManager().setNickname(manager.getNickname());

        tournamentRepo.save(tournament);
    }

    public void addRefereeByTournamentId(Long tournamentId, Long profileId) {

    }

    public List<TeamDTO> getTeamsByTournamentId(Long tournamentId) {
        return getTournamentById(tournamentId).getParticipants().
                stream().map(EntitiesMapper::teamToDTO).toList();
    }

    public List<TournamentDTO> getTournaments() {
        return tournamentRepo.findAll().stream().map(EntitiesMapper::tournamentToDTO).toList();
    }

    public List<TournamentDTO> getTournaments(Boolean isOfficial) {
        return tournamentRepo.findAllByIsOfficialOrderById(isOfficial).stream().map(EntitiesMapper::tournamentToDTO).toList();
    }

    public void shuffleTeams(Long tournamentId, String shuffleType) {

    }

    public Referee getRefereeById(Long id) {
        return refereeRepo.findById(id).orElseThrow(()
                ->
                new NotFoundException("Referee with id = " + id + " is not found"));
    }

    public RefereeDTO getRefereeDTOById(Long id) {
        return EntitiesMapper.refereeToDTO(getRefereeById(id));
    }

    public Player getPlayerById(Long id) {
        return playerRepo.findById(id).orElseThrow(()
                ->
                new NotFoundException("Player with id = " + id + " is not found"));
    }

    public Discipline getDisciplineByName(String discName) {
        return disciplineRepo.findByName(discName);
    }


}