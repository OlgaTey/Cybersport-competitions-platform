package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "AbsoluteTeams")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class AbsoluteTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Long captainId;

    @ManyToMany(mappedBy = "teams")
    private List<Profile> members;

    @NotNull
    @Column(nullable = false)
    private String description;
}
