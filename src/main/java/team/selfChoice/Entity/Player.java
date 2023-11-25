package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Players")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Player {

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
    @Column(nullable = false)
    private Long profileId;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "teamId", nullable = false)
    private Team team;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String country;
}
