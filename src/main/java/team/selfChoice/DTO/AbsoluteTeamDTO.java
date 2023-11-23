package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class AbsoluteTeamDTO {
    private Long id;
    private String name;
    private Long captainId;
    private List<Long> membersId;
    private String description;
}
