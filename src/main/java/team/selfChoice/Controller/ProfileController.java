package team.selfChoice.Controller;

import org.springframework.web.bind.annotation.*;
import team.selfChoice.Models.Profile;
import team.selfChoice.Models.Tournament;

import java.util.ArrayList;

@RestController
public interface ProfileController {

    @PostMapping("/profile")
    public void postProfile(@RequestBody Profile profile);

    @GetMapping("/profile/{id}")
    public Profile getProfileById(@PathVariable Long id);

    @DeleteMapping("/profile/{id}")
    public void deleteProfileById(@PathVariable Long id);

    @PutMapping("/profile/{id}")
    public void putProfileById(@PathVariable Long id, @RequestBody Profile profile);


}
