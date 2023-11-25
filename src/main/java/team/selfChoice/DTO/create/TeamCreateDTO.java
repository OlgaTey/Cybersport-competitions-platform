package team.selfChoice.DTO.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class TeamCreateDTO {
    @NonNull
    @NotNull
    @NotBlank
    private String name;

    @NonNull
    @NotNull
    @NotEmpty
    private List<Long> playersId;

    @NonNull
    @NotNull
    private Long captainId;

    @NonNull
    @NotNull
    private Integer position;

    private Map<String, Double> points;

    @NonNull
    @NotNull
    private Long tournamentId;
}
