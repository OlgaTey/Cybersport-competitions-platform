package team.selfChoice.Controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.ProfileDTO;
import team.selfChoice.Service.ProfileService;

@RestController
@AllArgsConstructor
public class ProfileControllerImpl implements ProfileController{
    @Autowired
    private final ProfileService profileService;
    @Override
    public void postProfile(ProfileDTO profile) {
        profileService.createProfile(profile);
    }

    @Override
    public ProfileDTO getProfileById(Long id) {
        return profileService.getProfileById(id);
    }

    @Override
    public void deleteProfileById(Long id) {
        profileService.deleteProfileById(id);
    }

    @Override
    public void putProfileById(Long id, ProfileDTO profile) {
        profileService.updateProfileById(id, profile);
    }
}
