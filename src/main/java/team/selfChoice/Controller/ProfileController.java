package team.selfChoice.Controller;

import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;
import team.selfChoice.DTO.ProfileDTO;
import team.selfChoice.DTO.create.ProfileCreateDTO;

import java.io.IOException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public interface ProfileController {

    @PostMapping("/profile")
    public void postProfile(@RequestBody ProfileCreateDTO profileDTO);

    @GetMapping("/profile/{id}")
    public ProfileDTO getProfileById(@PathVariable @Min(1) Long id);

    @DeleteMapping("/profile/{id}")
    public void deleteProfileById(@PathVariable @Min(1) Long id);

    @PutMapping("/profile/{id}")
    public void putProfileById(@PathVariable @Min(1) Long id, @RequestBody ProfileCreateDTO profileDTO);


}
