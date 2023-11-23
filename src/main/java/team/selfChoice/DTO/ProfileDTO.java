package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
public class ProfileDTO {
    private Long id;
    private String name;
    private String nickname;
    private Date birthday;
    private Boolean isMale;
    private String country;
    private Integer category;
    private List<Long> teamsId;
    private String contacts;
    private String description;
//    private PlayerStatDTO playerStat;
//    private RefereeStatDTO judgeStat;
}
