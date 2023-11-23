package team.selfChoice.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import team.selfChoice.DTO.ProfileDTO;

import java.io.IOException;

@RestController
public interface ProfileController {

    @PostMapping("/profile")
    public void postProfile(@RequestBody ProfileDTO profileDTO);

    @GetMapping("/profile/{id}")
    public ProfileDTO getProfileById(@PathVariable Long id);

    @DeleteMapping("/profile/{id}")
    public void deleteProfileById(@PathVariable Long id);

    @PutMapping("/profile/{id}")
    public void putProfileById(@PathVariable Long id, @RequestBody ProfileDTO profileDTO);


    @GetMapping("/exportProfile/{id}")
    public void downloadProfile(@PathVariable Long id, HttpServletResponse response) throws IOException;

}
