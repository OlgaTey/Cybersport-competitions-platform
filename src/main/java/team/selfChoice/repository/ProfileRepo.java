package team.selfChoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.selfChoice.Entity.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
}
