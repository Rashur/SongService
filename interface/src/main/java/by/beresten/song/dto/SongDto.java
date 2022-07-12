package by.beresten.song.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDto {


    private Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    @Size(min = 1, max = 100)
    private String artist;

    @NotBlank
    @Size(min = 1, max = 100)
    private String album;

    @NotBlank
    @Size(min = 1, max = 100)
    @Pattern(regexp = "^[0-9]{1,3}:[0-9]{1,2}:[0-9]{2}|[0-9]{1,2}:[0-9]{2}$")
    private String length;

    @NotBlank
    @Min(1)
    private String resourceId;

    @NotNull
    @Min(1700)
    @Max(2022)
    private Long year;

}
