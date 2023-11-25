package team.selfChoice.DTO.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@AllArgsConstructor
@Data
public class TournamentInfoCreateDTO {

    @NonNull
    @NotNull
    @NotBlank
    private String name;

    private String description;

    @NonNull
    @NotNull
    private Date start_date;

    @NonNull
    @NotNull
    private Date finish_date;

    @NonNull
    @NotNull
    @NotBlank
    private String discipline;

    @NonNull
    @NotNull
    private Date start_registration;

    @NonNull
    @NotNull
    private Date end_registration;

    private String location;
}
