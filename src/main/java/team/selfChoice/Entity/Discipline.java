package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Disciplines")
@RequiredArgsConstructor
@Data
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "discipline", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Tournament> tournaments;
}
