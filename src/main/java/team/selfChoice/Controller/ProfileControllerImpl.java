package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.ProfileDTO;

@RestController
public class ProfileControllerImpl implements ProfileController{
    @Override
    public void postProfile(ProfileDTO profileDTO) {

    }

    @Override
    public ProfileDTO getProfileById(Long id) {
        return null;
    }

    @Override
    public void deleteProfileById(Long id) {

    }

    @Override
    public void putProfileById(Long id, ProfileDTO profileDTO) {

    }
}
