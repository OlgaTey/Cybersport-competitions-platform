package team.selfChoice.DTO.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class PlayerCreateDTO {

    @NonNull
    @NotNull
    private Long profileId;

    @NonNull
    @NotNull
    @NotBlank
    private String nickname;

    @NonNull
    @NotNull
    private Long teamId;

    @NonNull
    @NotNull
    @NotBlank
    private String country;
}
