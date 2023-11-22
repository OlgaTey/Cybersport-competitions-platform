package team.selfChoice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Embeddable
@RequiredArgsConstructor
@Data
public class Manager {

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String nickname;

    @NotNull
    @Column(nullable = false)
    private Long chiefRefereeId;
}
