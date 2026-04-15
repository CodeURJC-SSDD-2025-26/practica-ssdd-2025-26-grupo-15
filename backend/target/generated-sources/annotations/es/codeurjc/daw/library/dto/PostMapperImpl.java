package es.codeurjc.daw.library.dto;

import es.codeurjc.daw.library.model.Post;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-15T23:43:15+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDTO toDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        Long id = null;
        String header = null;
        String ownerName = null;
        String description = null;
        String timeAgo = null;
        String contentLink = null;
        String actionType = null;

        id = post.getId();
        header = post.getHeader();
        ownerName = post.getOwnerName();
        description = post.getDescription();
        timeAgo = post.getTimeAgo();
        contentLink = post.getContentLink();
        actionType = post.getActionType();

        PostDTO postDTO = new PostDTO( id, header, ownerName, description, timeAgo, contentLink, actionType );

        return postDTO;
    }

    @Override
    public Post toEntity(PostCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Post post = new Post();

        post.setActionType( dto.actionType() );
        post.setHeader( dto.header() );
        post.setDescription( dto.description() );
        post.setContentLink( dto.contentLink() );

        return post;
    }
}
