package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Referees")
@RequiredArgsConstructor
@Data
public class Referee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String post;

    @NotNull
    @Column(nullable = false)
    private Integer category;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String country;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "tournamentId", nullable = false)
    private Tournament tournament;

    @NotNull
    @Column(nullable = false)
    private Long profileId;
}
