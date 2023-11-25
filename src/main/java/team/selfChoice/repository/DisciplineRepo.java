package team.selfChoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.selfChoice.Entity.Discipline;

public interface DisciplineRepo extends JpaRepository<Discipline, Long> {

    public Discipline findByName(String name);
}
