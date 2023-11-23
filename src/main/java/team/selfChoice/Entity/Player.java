package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "Players")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String nickname;

    @NotNull
    @Column(nullable = false)
    private Long profileId;

    @ManyToOne
    @JoinColumn(name = "teamId", nullable = false)
    private Team team;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String country;
}
