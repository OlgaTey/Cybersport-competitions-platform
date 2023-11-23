package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class TournamentInfoDTO {
    private String name;
    private String description;
    private Date start_date;
    private Date finish_date;
    private DisciplineDTO discipline;
    private Date start_registration;
    private Date end_registration;
    private String location;
}
