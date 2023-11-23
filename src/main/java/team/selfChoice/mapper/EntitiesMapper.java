package team.selfChoice.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import team.selfChoice.DTO.*;
import team.selfChoice.Entity.*;
import team.selfChoice.Service.MainService;

import java.util.List;

public class EntitiesMapper {
    private static final MainService service = new MainService();

    public static DisciplineDTO disciplineToDTO(Discipline pojo) {
        List<TournamentDTO> tournaments = pojo.getTournaments().stream()
                .map(EntitiesMapper::tournamentToDTO).toList();

        return new DisciplineDTO(pojo.getId(), pojo.getName(), tournaments);
    }

    public static Discipline DTOToDiscipline(DisciplineDTO dto) {
        List<Tournament> tournaments = dto.getTournaments().stream()
                .map(EntitiesMapper::DTOToTournament).toList();

        return new Discipline(dto.getId(), dto.getName(), tournaments);
    }
    public static MatchDTO matchToDTO(Match pojo) {
        List<Long> teamsId = pojo.getParticipants().stream()
                .map(Team::getId).toList();

        return new MatchDTO(pojo.getId(), teamsId, pojo.getTournament().getId());
    }

    public static Match DTOToMatch(MatchDTO dto) {
        List<Team> teams = dto.getParticipants().stream()
                .map(service::getTeamById).toList();
        Tournament tournament = service.getTournamentById(dto.getTournamentId());

        return new Match(dto.getId(), teams, tournament);
    }

    public static PlayerDTO playerToDTO(Player pojo) {
        return new PlayerDTO(pojo.getProfileId(), pojo.getProfileId(),
                pojo.getNickname(), pojo.getTeam().getId(),
                pojo.getCountry());
    }

    public static Player DTOToPlayer(PlayerDTO dto) {
        Team team = service.getTeamById(dto.getId());

        return new Player(dto.getId(), dto.getNickname(),
                dto.getProfileId(), team,
                dto.getCountry());
    }

    public static ProfileDTO profileToDTO(Profile pojo) {
        List<Long> teamsId = pojo.getTeams().stream()
                .map(AbsoluteTeam::getId).toList();

        return new ProfileDTO(pojo.getId(), pojo.getName(),
                pojo.getNickname(), pojo.getBirthday(), pojo.isMale(),
                pojo.getCountry(), pojo.getCategory(),
                teamsId, pojo.getContacts(),
                pojo.getDescription());
    }

    public static Profile DTOToProfile(ProfileDTO dto) {
        List<AbsoluteTeam> teams = dto.getTeamsId().stream()
                .map(service::getAbsoluteTeamById).toList();

        return new Profile(dto.getId(), dto.getName(),
                dto.getNickname(),dto.getBirthday(),
                dto.getIsMale(), dto.getCountry(),
                dto.getCategory(), teams,
                dto.getContacts(), dto.getDescription());
    }

    public static RefereeDTO refereeToDTO(Referee pojo) {
        return new RefereeDTO(pojo.getId(), pojo.getProfileId(),
                pojo.getNickname(), pojo.getPost(),
                pojo.getCategory(), pojo.getCountry(),
                pojo.getCity(), pojo.getTournament().getId());
    }

    public static Referee DTOToReferee(RefereeDTO dto) {
        Tournament tournament = service.getTournamentById(dto.getTournamentId());
        return new Referee(dto.getId(), dto.getNickname(),
                dto.getPost(), dto.getCategory(),
                dto.getCountry(), dto.getCity(),
                tournament, dto.getProfileId());
    }

    public static TeamDTO teamToDTO(Team pojo) {
        List<PlayerDTO> players = pojo.getPlayers().stream().map(EntitiesMapper::playerToDTO).toList();
        List<MatchDTO> matches = pojo.getMatches().stream().map(EntitiesMapper::matchToDTO).toList();

        return new TeamDTO(pojo.getId(), pojo.getName(),
                players, pojo.getCaptainId(),
                matches, pojo.getPosition(),
                pojo.getPoints(), pojo.getTournament().getId());
    }

    public static Team DTOToTeam(TeamDTO dto) {
        List<Player> players = dto.getPlayers().stream().map(EntitiesMapper::DTOToPlayer).toList();
        List<Match> matches = dto.getMatches().stream().map(EntitiesMapper::DTOToMatch).toList();
        Tournament tournament = service.getTournamentById(dto.getTournamentId());

        return new Team(dto.getId(), dto.getName(),
                players, dto.getCaptainId(),
                matches, dto.getPosition(),
                dto.getPoints(),tournament);
    }

    public static TournamentDTO tournamentToDTO(Tournament pojo) {
        TournamentInfoDTO info = createInfo(pojo);
        List<Long> matchesId = pojo.getMatches().stream().map(Match::getId).toList();
        List<Long> teamsId = pojo.getParticipants().stream().map(Team::getId).toList();
        List<Long> refereesId = pojo.getReferees().stream().map(Referee::getId).toList();

        return new TournamentDTO(pojo.getId(), matchesId,
                managerToDTO(pojo.getManager()),
                teamsId, refereesId, info);
    }

    public static Tournament DTOToTournament(TournamentDTO dto) {
        List<Match> matches = dto.getMatchesId().stream().map(service::getMatchById).toList();
        List<Team> teams = dto.getTeamsId().stream().map(service::getTeamById).toList();
        List<Referee> referees = dto.getRefereesId().stream().map(service::getRefereeById).toList();

        return new Tournament(dto.getId(), matches,
                dto.getInfo().getName(),
                dto.getInfo().getStart_registration(),dto.getInfo().getEnd_registration(),
                dto.getInfo().getStart_date(), dto.getInfo().getFinish_date(),
                dto.getInfo().getDescription(), dto.getInfo().getLocation(),
                DTOToDiscipline(dto.getInfo().getDiscipline()), DTOToManager(dto.getManager()),
                referees, teams);
    }

    private static TournamentInfoDTO createInfo(Tournament pojo) {
        return new TournamentInfoDTO(pojo.getName(), pojo.getDescription(),
                pojo.getStartDate(), pojo.getEndDate(),
                disciplineToDTO(pojo.getDiscipline()),
                pojo.getStartRegistration(), pojo.getEndRegistration(),
                pojo.getLocation());
    }

    private static ManagerDTO managerToDTO(Manager pojo) {
        return new ManagerDTO(pojo.getChiefRefereeId(), pojo.getNickname());
    }

    private static Manager DTOToManager(ManagerDTO dto) {
        return new Manager(dto.getNickname(), dto.getChiefId());
    }

    private static AbsoluteTeamDTO AbsoluteTeamToDTO(AbsoluteTeam pojo) {
        List<Long> membersId = pojo.getMembers().stream().map(Profile::getId).toList();

        return new AbsoluteTeamDTO(pojo.getId(), pojo.getName(),
                pojo.getCaptainId(), membersId,
                pojo.getDescription());
    }

    private static AbsoluteTeam DTOToAbsoluteTeam(AbsoluteTeamDTO dto) {
        List<Profile> profiles = dto.getMembersId().stream().map(service::getProfileById).toList();

        return new AbsoluteTeam(dto.getId(), dto.getName(), dto.getCaptainId(), profiles, dto.getDescription());
    }
}
