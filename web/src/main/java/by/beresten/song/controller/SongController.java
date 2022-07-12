package by.beresten.song.controller;

import by.beresten.song.dto.SongDto;
import by.beresten.song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(value = "/songs")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Long save(@Valid @RequestBody SongDto songDto) {
        return songService.create(songDto);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SongDto getById(@PathVariable Long id) {
        return songService.getById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Long> deleteAllById(@RequestParam Set<Long> ids) {
        return songService.deleteByIds(ids);
    }
}
