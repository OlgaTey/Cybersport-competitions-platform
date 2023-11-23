package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tournaments")
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

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Date startRegistration;

    @NotNull
    @Column(nullable = false)
    private Date endRegistration;

    @NotNull
    @Column(nullable = false)
    private Date startDate;

    @NotNull
    @Column(nullable = false)
    private Date endDate;

    private String description;

    private String location;

    @ManyToOne
    @JoinColumn(name = "disciplineId", nullable = false)
    private Discipline discipline;

    @Embedded
    @NotNull
    private Manager manager;

    @OneToMany(mappedBy = "tournament", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Referee> referees;

    @OneToMany(mappedBy = "tournament")
    private List<Team> participants;
}
