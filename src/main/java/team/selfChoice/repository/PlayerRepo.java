package team.selfChoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.selfChoice.Entity.Player;

public interface PlayerRepo extends JpaRepository<Player, Long> {
}
