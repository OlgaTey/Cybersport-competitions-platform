package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PlayerDTO {
    private Long profileId;
    private String nickname;
    private String gameRole;
}
