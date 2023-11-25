package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Referees")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Referee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String nickname;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String post;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Integer category;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String country;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String city;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "tournamentId", nullable = false)
    private Tournament tournament;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Long profileId;
}
