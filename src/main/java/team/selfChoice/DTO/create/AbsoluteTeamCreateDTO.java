package team.selfChoice.DTO.create;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@Data
public class AbsoluteTeamCreateDTO {

    @NonNull
    @NotNull
    private String name;

    @NonNull
    @NotNull
    private Long captainId;

    @NonNull
    @NotNull
    @NotEmpty
    private List<Long> membersId;

    @NonNull
    @NotNull
    private String description;
}
