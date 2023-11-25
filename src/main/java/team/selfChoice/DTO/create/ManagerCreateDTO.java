package team.selfChoice.DTO.create;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class ManagerCreateDTO {

    @NonNull
    @NotNull
    private Long chiefId;

    @NonNull
    @NotNull
    @NotBlank
    private String nickname;
}
