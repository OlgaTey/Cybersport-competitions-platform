package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.Models.Profile;

@RestController
public class ProfileControllerImpl implements ProfileController{
    @Override
    public void postProfile(Profile profile) {

    }

    @Override
    public Profile getProfileById(Long id) {
        return null;
    }

    @Override
    public void deleteProfileById(Long id) {

    }

    @Override
    public void putProfileById(Long id, Profile profile) {

    }
}
