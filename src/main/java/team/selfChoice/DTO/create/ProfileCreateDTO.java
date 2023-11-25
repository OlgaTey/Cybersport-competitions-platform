package team.selfChoice.DTO.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class ProfileCreateDTO {

    @NonNull
    @NotNull
    @NotBlank
    private String name;

    @NonNull
    @NotNull
    @NotBlank
    private String nickname;

    @NonNull
    @NotNull
    private Date birthday;

    @NonNull
    @NotNull
    private Boolean isMale;

    @NonNull
    @NotNull
    @NotBlank
    private String country;

    private Integer category;

    private List<Long> teamsId;

    private String contacts;

    private String description;
//    private PlayerStatDTO playerStat;
//    private RefereeStatDTO judgeStat;
}
