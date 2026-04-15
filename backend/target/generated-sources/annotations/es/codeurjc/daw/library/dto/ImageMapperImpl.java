package es.codeurjc.daw.library.dto;

import es.codeurjc.daw.library.model.Image;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-15T23:43:15+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageDTO toDTO(Image image) {
        if ( image == null ) {
            return null;
        }

        Long id = null;

        id = image.getId();

        ImageDTO imageDTO = new ImageDTO( id );

        return imageDTO;
    }

    @Override
    public Image toEntity(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        Image image = new Image();

        image.setId( imageDTO.id() );

        return image;
    }
}
