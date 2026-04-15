package es.codeurjc.daw.library.dto;

import es.codeurjc.daw.library.model.Comment;
import es.codeurjc.daw.library.model.Solution;
import es.codeurjc.daw.library.model.User;
import java.sql.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-15T23:43:15+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDTO toDTO(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        Long id = null;
        String text = null;
        Date lastUpdate = null;
        UserBasicInfoDTO owner = null;
        SolutionBasicInfoDTO solution = null;

        id = comment.getId();
        text = comment.getText();
        lastUpdate = comment.getLastUpdate();
        owner = userToUserBasicInfoDTO( comment.getOwner() );
        solution = solutionToSolutionBasicInfoDTO( comment.getSolution() );

        CommentDTO commentDTO = new CommentDTO( id, text, lastUpdate, owner, solution );

        return commentDTO;
    }

    @Override
    public Comment toEntity(CommentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setText( dto.text() );
        comment.setLastUpdate( dto.lastUpdate() );
        comment.setOwner( userBasicInfoDTOToUser( dto.owner() ) );
        comment.setSolution( solutionBasicInfoDTOToSolution( dto.solution() ) );

        return comment;
    }

    @Override
    public Comment toEntity(CommentPostDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setText( dto.text() );

        return comment;
    }

    protected UserBasicInfoDTO userToUserBasicInfoDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;

        id = user.getId();
        name = user.getName();
        email = user.getEmail();

        UserBasicInfoDTO userBasicInfoDTO = new UserBasicInfoDTO( id, name, email );

        return userBasicInfoDTO;
    }

    protected SolutionBasicInfoDTO solutionToSolutionBasicInfoDTO(Solution solution) {
        if ( solution == null ) {
            return null;
        }

        Long id = null;
        String name = null;

        id = solution.getId();
        name = solution.getName();

        SolutionBasicInfoDTO solutionBasicInfoDTO = new SolutionBasicInfoDTO( id, name );

        return solutionBasicInfoDTO;
    }

    protected User userBasicInfoDTOToUser(UserBasicInfoDTO userBasicInfoDTO) {
        if ( userBasicInfoDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userBasicInfoDTO.id() );
        user.setName( userBasicInfoDTO.name() );
        user.setEmail( userBasicInfoDTO.email() );

        return user;
    }

    protected Solution solutionBasicInfoDTOToSolution(SolutionBasicInfoDTO solutionBasicInfoDTO) {
        if ( solutionBasicInfoDTO == null ) {
            return null;
        }

        Solution solution = new Solution();

        solution.setName( solutionBasicInfoDTO.name() );

        return solution;
    }
}
