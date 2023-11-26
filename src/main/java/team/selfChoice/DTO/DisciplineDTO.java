package team.selfChoice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class DisciplineDTO {
    private Long id;
    private String name;
    private List<Long> tournamentsId;
}
