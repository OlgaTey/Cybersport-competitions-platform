package team.selfChoice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Profile {
    private Long id;
    private String name;
    private String nickname;
    private String birthday;
    private String role;
}
