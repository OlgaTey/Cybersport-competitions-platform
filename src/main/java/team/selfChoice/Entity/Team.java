package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Teams")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Player> players;

    @NotNull
    @Column(nullable = false)
    private Long captainId;

    @ManyToMany(mappedBy = "participants")
    private List<Match> matches;

    @NotNull
    @Column(nullable = false)
    private Integer position;

    @ElementCollection
    @CollectionTable(name = "TeamPointingMapping", joinColumns = {@JoinColumn(name = "teamId", referencedColumnName = "id")})
    @MapKeyColumn(name = "parametrName")
    @Column(name = "value")
    private Map<String, Double> points;

    @ManyToOne
    @JoinColumn(name = "tournamentId", nullable = false)
    private Tournament tournament;
}
