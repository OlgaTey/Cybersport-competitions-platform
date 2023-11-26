package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tournaments")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Match> matches;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Date startRegistration;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Date endRegistration;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Date startDate;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Date endDate;

    private String description;

    private String location;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "discipline_id", nullable = false)
    private Discipline discipline;

    @Embedded
    @NonNull
    @NotNull
    private Manager manager;

    @NonNull
    @NotNull
    @OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Referee> referees;

    @OneToMany(mappedBy = "tournament")
    private List<Team> participants;

    @NonNull
    @NotNull
    private Boolean isOfficial;
}
