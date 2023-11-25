package team.selfChoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.selfChoice.Entity.Tournament;

import java.util.List;

public interface TournamentRepo extends JpaRepository<Tournament, Long> {

    public List<Tournament> findAllByIsOfficialOrderById(Boolean isOfficial);
}
