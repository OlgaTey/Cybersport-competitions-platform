package team.selfChoice.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Matches")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @ManyToMany
    @JoinTable(name = "matchesIn",
            joinColumns = @JoinColumn(name = "matchId", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "teamId"))
    private List<Team> participants;

    @ManyToOne
    @JoinColumn(name = "tournamentId", nullable = false)
    private Tournament tournament;
}
