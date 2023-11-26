package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Teams")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NonNull
    @NotNull
    @NotEmpty
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Player> players;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Long captainId;

    @ManyToMany(mappedBy = "participants")
    private List<Match> matches;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Integer position;

    @ElementCollection
    @CollectionTable(name = "TeamPointingMapping", joinColumns = {@JoinColumn(name = "teamId", referencedColumnName = "id")})
    @MapKeyColumn(name = "parametrName")
    @Column(name = "value")
    private Map<String, Double> points;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "tournamentId", nullable = false)
    private Tournament tournament;
}
