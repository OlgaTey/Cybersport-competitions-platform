package team.selfChoice.DTO.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
@Data
public class DisciplineCreateDTO {

    @NonNull
    @NotNull
    @NotBlank
    private String name;
    private List<Long> tournamentsId;
}
