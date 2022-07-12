package by.beresten.song.service;

import by.beresten.song.dto.SongDto;
import java.util.Set;

public interface SongService {

    Long create(SongDto songDto);

    SongDto getById(Long id);

    Set<Long> deleteByIds(Set<Long> ids);
}
