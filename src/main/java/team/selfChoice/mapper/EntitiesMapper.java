package team.selfChoice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import team.selfChoice.DTO.*;
import team.selfChoice.DTO.create.*;
import team.selfChoice.Entity.*;
import team.selfChoice.Service.MainService;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntitiesMapper {

    @Autowired
    private final MainService service;

    public EntitiesMapper(MainService service) {
        this.service = service;
    }

    public DisciplineDTO disciplineToDTO(Discipline pojo) {
        List<TournamentDTO> tournaments = pojo.getTournaments().stream()
                .map(this::tournamentToDTO).toList();

        return new DisciplineDTO(pojo.getId(), pojo.getName(), tournaments);
    }

    public Discipline DTOToDiscipline(DisciplineCreateDTO dto) {
        List<Tournament> tournaments = null;

        if(dto.getTournamentsId() != null && !dto.getTournamentsId().isEmpty()) {
            tournaments = dto.getTournamentsId().stream()
                    .map(service::getTournamentById).toList();
        }

        Discipline discipline = new Discipline(dto.getName());
        discipline.setTournaments(tournaments);

        return discipline;
    }
    public MatchDTO matchToDTO(Match pojo) {
        List<Long> teamsId = pojo.getParticipants().stream()
                .map(Team::getId).toList();

        return new MatchDTO(pojo.getId(), teamsId, pojo.getTournament().getId());
    }

    public Match DTOToMatch(MatchCreateDTO dto) {
        List<Team> teams = null;
        Tournament tournament = service.getTournamentById(dto.getTournamentId());

        if(dto.getParticipants() != null && !dto.getParticipants().isEmpty()) {
            teams = dto.getParticipants().stream()
                    .map(service::getTeamById).toList();
        }

        Match match = new Match(tournament);
        match.setParticipants(teams);

        return match;
    }

    public Match updateMatch(MatchCreateDTO dto, Match match) {
        List<Team> teams = null;
        Tournament tournament = service.getTournamentById(dto.getTournamentId());

        if(dto.getParticipants() != null && !dto.getParticipants().isEmpty()) {
            teams = dto.getParticipants().stream()
                    .map(service::getTeamById).toList();
        }

        match.setTournament(tournament);
        match.setParticipants(teams);

        return match;
    }

    public PlayerDTO playerToDTO(Player pojo) {
        return new PlayerDTO(pojo.getProfileId(), pojo.getProfileId(),
                pojo.getNickname(), pojo.getTeam().getId(),
                pojo.getCountry());
    }

    public Player DTOToPlayer(PlayerCreateDTO dto) {
        Team team = service.getTeamById(dto.getTeamId());

        return new Player(dto.getNickname(),
                dto.getProfileId(), team,
                dto.getCountry());
    }

    public  ProfileDTO profileToDTO(Profile pojo) {
        List<Long> teamsId = pojo.getTeams().stream()
                .map(AbsoluteTeam::getId).toList();

        return new ProfileDTO(pojo.getId(), pojo.getName(),
                pojo.getNickname(), pojo.getBirthday(), pojo.getIsMale(),
                pojo.getCountry(), pojo.getCategory(),
                teamsId, pojo.getContacts(),
                pojo.getDescription());
    }

    public  Profile DTOToProfile(ProfileCreateDTO dto) {
        List<AbsoluteTeam> teams = null;

        if(dto.getTeamsId() != null && !dto.getTeamsId().isEmpty()) {
            teams = dto.getTeamsId().stream()
                    .map(service::getAbsoluteTeamById).toList();

        }

        Profile profile = new Profile(dto.getName(),
                dto.getNickname(),dto.getBirthday(),
                dto.getIsMale(), dto.getCountry(),
                dto.getCity());
        profile.setCategory(dto.getCategory());
        profile.setTeams(teams);
        profile.setContacts(dto.getContacts());
        profile.setDescription(dto.getDescription());

        return profile;
    }

    public  Profile updateProfile(ProfileCreateDTO dto, Profile profile) {
        List<AbsoluteTeam> teams = null;

        if(dto.getTeamsId() != null && !dto.getTeamsId().isEmpty()) {
            teams = dto.getTeamsId().stream()
                    .map(service::getAbsoluteTeamById).toList();

        }

        profile.setName(dto.getName());
        profile.setNickname(dto.getNickname());
        profile.setBirthday(dto.getBirthday());
        profile.setIsMale(dto.getIsMale());
        profile.setCountry(dto.getCountry());
        profile.setCategory(dto.getCategory());
        profile.setTeams(teams);
        profile.setContacts(dto.getContacts());
        profile.setDescription(dto.getDescription());

        return profile;
    }

    public  RefereeDTO refereeToDTO(Referee pojo) {
        return new RefereeDTO(pojo.getId(), pojo.getProfileId(),
                pojo.getNickname(), pojo.getPost(),
                pojo.getCategory(), pojo.getCountry(),
                pojo.getCity(), pojo.getTournament().getId());
    }

//    public  Referee DTOToReferee(RefereeCreateDTO dto) {
//        Tournament tournament = service.getTournamentById(dto.getTournamentId());
//        return new Referee(dto.getNickname(),
//                dto.getPost(), dto.getCategory(),
//                dto.getCountry(), dto.getCity(),
//                tournament, dto.getProfileId());
//    }

    public  TeamDTO teamToDTO(Team pojo) {
        List<PlayerDTO> players = pojo.getPlayers().stream().map(this::playerToDTO).toList();
        List<MatchDTO> matches = pojo.getMatches().stream().map(this::matchToDTO).toList();

        return new TeamDTO(pojo.getId(), pojo.getName(),
                players, pojo.getCaptainId(),
                matches, pojo.getPosition(),
                pojo.getPoints(), pojo.getTournament().getId());
    }

    public  Team DTOToTeam(TeamCreateDTO dto) {
        List<Player> players = dto.getPlayersId().stream().map(service::getPlayerById).toList();
        Tournament tournament = service.getTournamentById(dto.getTournamentId());

        Team team = new Team(dto.getName(),
                players, dto.getCaptainId(),
                dto.getPosition(), tournament);
        team.setPoints(dto.getPoints());
        team.setMatches(null);

        return team;
    }

    public  Team updateTeam(TeamCreateDTO dto, Team team) {
        List<Player> players = dto.getPlayersId().stream().map(service::getPlayerById).toList();
        Tournament tournament = service.getTournamentById(dto.getTournamentId());

        team.setName(dto.getName());
        team.setPlayers(players);
        team.setCaptainId(dto.getCaptainId());
        team.setPosition(dto.getPosition());
        team.setTournament(tournament);
        team.setPoints(dto.getPoints());

        return team;
    }

    public  TournamentDTO tournamentToDTO(Tournament pojo) {
        TournamentInfoDTO info = createInfo(pojo);
        List<Long> matchesId = pojo.getMatches().stream().map(Match::getId).toList();
        List<Long> teamsId = pojo.getParticipants().stream().map(Team::getId).toList();
        List<Long> refereesId = pojo.getReferees().stream().map(Referee::getId).toList();

        return new TournamentDTO(pojo.getId(), matchesId,
                managerToDTO(pojo.getManager()),
                teamsId, refereesId, info);
    }

    public  Tournament DTOToTournament(TournamentCreateDTO dto) {
        List<Match> matches = null;
        List<Team> teams = null;
        List<Referee> referees = new ArrayList<>();
        Profile managerProfile = service.getProfileById(dto.getManager().getChiefId());
        Discipline discipline = service.getDisciplineByName(dto.getInfo().getDiscipline());
        boolean isOfficial = false;

        if(dto.getMatchesId() != null && !dto.getMatchesId().isEmpty()) {
            matches = dto.getMatchesId().stream().map(service::getMatchById).toList();
            teams = dto.getTeamsId().stream().map(service::getTeamById).toList();
        }

        if(dto.getIsOfficial() && managerProfile.getIsOfficialReferee()) {
            isOfficial = true;
        }

        Tournament tournament = new Tournament(dto.getInfo().getName(),
                dto.getInfo().getStart_registration(),dto.getInfo().getEnd_registration(),
                dto.getInfo().getStart_date(), dto.getInfo().getFinish_date(),
                discipline, DTOToManager(dto.getManager()),
                referees, isOfficial);
        tournament.setDescription(dto.getInfo().getDescription());
        tournament.setLocation(dto.getInfo().getDescription());
        tournament.setParticipants(teams);
        tournament.setMatches(matches);
        tournament.setReferees(dto.getRefereesProfileId().stream()
                .map(rId -> profileToReferee(service.getProfileById(rId), tournament)).toList());

        return tournament;
    }

    public  Tournament updateTournament(TournamentCreateDTO dto, Tournament tournament) {
        List<Match> matches = null;
        List<Team> teams = null;
        List<Referee> referees = dto.getRefereesProfileId().stream().map(service::getRefereeById).toList();
        Discipline discipline = service.getDisciplineByName(dto.getInfo().getDiscipline());

        if(dto.getMatchesId() != null && !dto.getMatchesId().isEmpty()) {
            matches = dto.getMatchesId().stream().map(service::getMatchById).toList();
            teams = dto.getTeamsId().stream().map(service::getTeamById).toList();
        }

        tournament.setName(dto.getInfo().getName());
        tournament.setStartRegistration(dto.getInfo().getStart_registration());
        tournament.setEndRegistration(dto.getInfo().getEnd_registration());
        tournament.setStartDate(dto.getInfo().getStart_date());
        tournament.setEndDate(dto.getInfo().getFinish_date());
        tournament.setDiscipline(discipline);
        tournament.setManager(DTOToManager(dto.getManager()));
        tournament.setReferees(referees);

        tournament.setDescription(dto.getInfo().getDescription());
        tournament.setLocation(dto.getInfo().getDescription());
        tournament.setParticipants(teams);
        tournament.setMatches(matches);

        return tournament;
    }

    private  TournamentInfoDTO createInfo(Tournament pojo) {
        return new TournamentInfoDTO(pojo.getName(), pojo.getDescription(),
                pojo.getStartDate(), pojo.getEndDate(),
                disciplineToDTO(pojo.getDiscipline()),
                pojo.getStartRegistration(), pojo.getEndRegistration(),
                pojo.getLocation());
    }

    private  ManagerDTO managerToDTO(Manager pojo) {
        return new ManagerDTO(pojo.getChiefRefereeId(), pojo.getNickname());
    }

    private  Manager DTOToManager(ManagerCreateDTO dto) {
        return new Manager(dto.getNickname(), dto.getChiefId());
    }

    public  AbsoluteTeamDTO absoluteTeamToDTO(AbsoluteTeam pojo) {
        List<Long> membersId = pojo.getMembers().stream().map(Profile::getId).toList();

        return new AbsoluteTeamDTO(pojo.getId(), pojo.getName(),
                pojo.getCaptainId(), membersId,
                pojo.getDescription());
    }

    public  AbsoluteTeam DTOToAbsoluteTeam(AbsoluteTeamCreateDTO dto) {
        List<Profile> profiles = dto.getMembersId().stream().map(service::getProfileById).toList();

        return new AbsoluteTeam(dto.getName(), dto.getCaptainId(),
                profiles, dto.getDescription());
    }

    public  Referee profileToReferee(Profile profile, Tournament tournament) {
        return new Referee(profile.getNickname(),
                profile.getCategory(),
                profile.getCountry(), profile.getCity(),
                tournament, profile.getId());

    }
}
