package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.antlr.v4.runtime.misc.Pair;

@Entity
@Table(name = "Duels")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class Duel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;


    @NonNull
    @NotNull
    @Column(nullable = false)
    private Team team1;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Team team2;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;
}
