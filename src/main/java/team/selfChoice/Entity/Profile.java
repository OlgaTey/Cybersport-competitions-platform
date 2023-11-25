package team.selfChoice.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Profiles")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Profile {

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
    @NotBlank
    @Column(nullable = false)
    private String nickname;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Date birthday;

    @NonNull
    @NotNull
    private Boolean isMale;

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String country;

    private Integer category;

    @ManyToMany
    @JoinTable(name = "teems_in",
    joinColumns = @JoinColumn(name = "profile_id", nullable = false),
    inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<AbsoluteTeam> teams;

    private String contacts;

    private String description;

    private Boolean isOfficialReferee;
}
