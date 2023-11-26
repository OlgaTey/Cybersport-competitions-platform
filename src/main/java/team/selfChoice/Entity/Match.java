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
    @JoinTable(name = "matches_in",
            joinColumns = @JoinColumn(name = "match_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> participants;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

//    @OneToMany(mappedBy = "match", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    private List<Duel> duels;

    @OneToMany(mappedBy = "nextMatch", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Match> previousMatches;

    @ManyToOne
    @JoinColumn(name = "next_match_id")
    private Match nextMatch;

    @ElementCollection
    private List<Long> adjacentMatchesId;
}
