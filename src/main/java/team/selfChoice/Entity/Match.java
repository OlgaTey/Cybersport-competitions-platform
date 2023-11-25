package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Matches")
@NoArgsConstructor(force = true)
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

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "tournamentId", nullable = false)
    private Tournament tournament;
}
