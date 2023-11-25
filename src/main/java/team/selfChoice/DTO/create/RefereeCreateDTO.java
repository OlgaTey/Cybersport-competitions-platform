package team.selfChoice.DTO.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class RefereeCreateDTO {

    @NonNull
    @NotNull
    private Long profileId;

    @NonNull
    @NotNull
    @NotBlank
    private String nickname;

    @NonNull
    @NotNull
    @NotBlank
    private String post;

    @NonNull
    @NotNull
    private Integer category;

    @NonNull
    @NotNull
    @NotBlank
    private String country;

    @NonNull
    @NotNull
    @NotBlank
    private String city;

    @NonNull
    @NotNull
    private Long tournamentId;
}
