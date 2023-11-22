package team.selfChoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.selfChoice.Entity.Match;

public interface MatchRepo extends JpaRepository<Match, Long> {
}
