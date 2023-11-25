package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "AbsoluteTeams")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class AbsoluteTeam {

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
    @Column(nullable = false)
    private Long captainId;

    @NonNull
    @NotNull
    @NotEmpty
    @ManyToMany(mappedBy = "teams")
    private List<Profile> members;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private String description;
}
