package by.beresten.song.mapper;

import by.beresten.song.dto.SongDto;
import by.beresten.song.model.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface SongMapper {

    SongMapper INSTANCE = Mappers.getMapper(SongMapper.class);

    @Mappings({
            @Mapping(target = "id", source = "song.id"),
            @Mapping(target = "name", source = "song.name"),
            @Mapping(target = "artist", source = "song.artist"),
            @Mapping(target = "album", source = "song.album"),
            @Mapping(target = "length", source = "song.length"),
            @Mapping(target = "resourceId", source = "song.resourceId"),
            @Mapping(target = "year", source = "song.year")
    })
    SongDto songToSongDto(Song song);

    @Mappings({
            @Mapping(target = "id", source = "songDto.id"),
            @Mapping(target = "name", source = "songDto.name"),
            @Mapping(target = "artist", source = "songDto.artist"),
            @Mapping(target = "album", source = "songDto.album"),
            @Mapping(target = "length", source = "songDto.length"),
            @Mapping(target = "resourceId", source = "songDto.resourceId"),
            @Mapping(target = "year", source = "songDto.year")
    })
    Song songDtoToSong(SongDto songDto);
}
