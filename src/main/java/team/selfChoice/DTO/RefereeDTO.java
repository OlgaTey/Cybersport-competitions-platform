package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RefereeDTO {
    private Long id;
    private Long profileId;
    private String nickname;
    private String post;
    private Integer category;
    private String country;
    private String city;
    private Long tournamentId;
}
