package team.selfChoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.selfChoice.Entity.Team;

public interface TeamRepo extends JpaRepository<Team, Long> {
}
