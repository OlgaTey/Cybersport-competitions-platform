package team.selfChoice.DTO.create;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class RefereeAddingDTO {

    @NonNull
    private String Post;

    @NonNull
    private Long profileId;
}
