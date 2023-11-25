package team.selfChoice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.create.DisciplineCreateDTO;
import team.selfChoice.Service.MainService;

@RestController
@RequestMapping("/discipline")
@AllArgsConstructor
public class disciplineControllerImpl implements disciplineController {

    @Autowired
    private MainService service;

    @Override
    public void createDiscipline(DisciplineCreateDTO dto) {
        service.createDiscipline(dto);
    }
}
