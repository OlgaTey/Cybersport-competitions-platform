package team.selfChoice.DTO.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@Data
public class MatchCreateDTO {
    private List<Long> participants;
//    private Map result;

    @NonNull
    @NotNull
    private Long tournamentId;
}
