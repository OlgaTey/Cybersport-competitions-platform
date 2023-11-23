package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Profiles")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.PRIVATE)
    private Long id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String nickname;

    @NotNull
    @Column(nullable = false)
    private Date birthday;

    private boolean isMale;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String country;

    private Integer category;

    @ManyToMany
    @JoinTable(name = "teemsIn",
    joinColumns = @JoinColumn(name = "profileId", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "teamId"))
    private List<AbsoluteTeam> teams;

    private String contacts;

    private String description;
}
