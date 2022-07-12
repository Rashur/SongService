package by.beresten.song.service.impl;

import by.beresten.song.dto.SongDto;
import by.beresten.song.exception.SongNotFoundException;
import by.beresten.song.mapper.SongMapper;
import by.beresten.song.model.Song;
import by.beresten.song.repository.SongRepository;
import by.beresten.song.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final SongMapper songMapper;

    @Autowired
    public SongServiceImpl(SongRepository songRepository, SongMapper songMapper) {
        this.songRepository = songRepository;
        this.songMapper = songMapper;
    }

    @Override
    public Long create(SongDto songDto) {
        var song = songMapper.songDtoToSong(songDto);
        log.info("IN SongServiceImpl create() save song: {}", song);
        return songRepository.save(song).getId();
    }

    @Override
    public SongDto getById(Long id) {
        var expectedSong = songRepository.findById(id).orElseThrow(
                () -> new SongNotFoundException("Song with id " + id + " does not exist"));
        log.info("IN SongServiceImpl getById() found song: {}, with id: {}", expectedSong, id);
        return songMapper.songToSongDto(expectedSong);
    }

    @Override
    public Set<Long> deleteByIds(Set<Long> ids) {
        var expectedSong = songRepository.findAllById(ids).stream().map(Song::getId).collect(Collectors.toSet());
        expectedSong.forEach(songRepository::deleteById);
        log.info("IN SongServiceImpl deleteByIds() delete songs with id: {}", expectedSong);
        return expectedSong;
    }
}
