package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.create.DisciplineCreateDTO;

@RestController("/discipline")
public interface disciplineController {

    @PostMapping
    public void createDiscipline(@RequestBody DisciplineCreateDTO dto);
}
