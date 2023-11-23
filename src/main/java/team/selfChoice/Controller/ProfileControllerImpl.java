package team.selfChoice.Controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import team.selfChoice.DTO.ProfileDTO;
import team.selfChoice.Excel.ExcelFileExporter;
import team.selfChoice.Service.MainService;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class ProfileControllerImpl implements ProfileController{
    @Autowired
    private final MainService profileService;
    @Override
    public void postProfile(ProfileDTO profile) {
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
    public void putProfileById(Long id, ProfileDTO profile) {
        profileService.updateProfileById(id, profile);
    }

    @Override
    public void downloadProfile(Long id, HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=customers.xlsx");
        ByteArrayInputStream stream = ExcelFileExporter.ProfileToExcelFile(id);
        IOUtils.copy(stream, response.getOutputStream());
    }

}
