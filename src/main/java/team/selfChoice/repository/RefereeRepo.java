package team.selfChoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.selfChoice.Entity.Referee;

public interface RefereeRepo extends JpaRepository<Referee, Long> {
}
