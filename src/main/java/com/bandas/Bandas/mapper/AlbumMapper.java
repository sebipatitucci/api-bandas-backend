package com.bandas.Bandas.mapper;

import com.bandas.Bandas.dto.AlbumDto;
import com.bandas.Bandas.models.Album;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    Album toAlbum(AlbumDto albumDto);

    AlbumDto toAlbumDto(Album album);

    List<AlbumDto> toAlbumDtos(List<Album> albums);

    void updateAlbum(@MappingTarget Album album, Album albumDto);

    default Optional<AlbumDto> toAlbumDto(Optional<Album> album) {
        return null;
    }
}
