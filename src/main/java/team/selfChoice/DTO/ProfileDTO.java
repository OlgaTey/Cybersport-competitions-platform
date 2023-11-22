package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProfileDTO {
    private Long id;
    private String name;
    private String nickname;
    private String birthday;
    private PlayerStatDTO playerStat;
    private JudgeStatDTO judgeStat;
}
