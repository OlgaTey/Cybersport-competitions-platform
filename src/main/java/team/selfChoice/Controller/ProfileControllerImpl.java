package team.selfChoice.Controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.ProfileDTO;
import team.selfChoice.DTO.create.ProfileCreateDTO;
import team.selfChoice.Service.MainService;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class ProfileControllerImpl implements ProfileController{
    @Autowired
    private final MainService profileService;
    @Override
    public void postProfile(ProfileCreateDTO profile) {
        profileService.createProfile(profile);
    }

    @Override
    public ProfileDTO getProfileById(Long id) {
        return profileService.getProfileDTOById(id);
    }

    @Override
    public void deleteProfileById(Long id) {
        profileService.deleteProfileById(id);
    }

    @Override
    public void putProfileById(Long id, ProfileCreateDTO profile) {
        profileService.updateProfileById(id, profile);
    }

}
