package team.selfChoice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Manager {

    @NonNull
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String nickname;

    @NonNull
    @NotNull
    @Column(nullable = false)
    private Long chiefRefereeId;
}
