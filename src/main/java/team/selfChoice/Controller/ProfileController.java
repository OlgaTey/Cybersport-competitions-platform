package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.*;
import team.selfChoice.DTO.ProfileDTO;

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


}
