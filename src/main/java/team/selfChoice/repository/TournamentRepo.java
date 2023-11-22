package team.selfChoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.selfChoice.Entity.Tournament;

public interface TournamentRepo extends JpaRepository<Tournament, Long> {
}
