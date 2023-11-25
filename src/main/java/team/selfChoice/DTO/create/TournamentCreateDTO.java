package team.selfChoice.DTO.create;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@Data
public class TournamentCreateDTO {

    private List<Long> matchesId;

    @Embedded
    @NonNull
    @NotNull
    private ManagerCreateDTO manager;
    private List<Long> teamsId;

    @NonNull
    @NotNull
    @NotEmpty
    private List<Long> refereesId;

    @NonNull
    @NotNull
    private TournamentInfoCreateDTO info;
}
