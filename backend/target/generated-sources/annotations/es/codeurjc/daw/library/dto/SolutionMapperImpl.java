package es.codeurjc.daw.library.dto;

import es.codeurjc.daw.library.model.Comment;
import es.codeurjc.daw.library.model.Exercise;
import es.codeurjc.daw.library.model.Image;
import es.codeurjc.daw.library.model.Solution;
import es.codeurjc.daw.library.model.User;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-15T23:43:15+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class SolutionMapperImpl implements SolutionMapper {

    @Override
    public SolutionDTO toDTO(Solution entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        UserBasicInfoDTO owner = null;
        Date lastUpdate = null;
        String description = null;
        ExerciseBasicInfoDTO exercise = null;
        ImageDTO solImage = null;
        List<CommentDTO> comments = null;

        id = entity.getId();
        name = entity.getName();
        owner = userToUserBasicInfoDTO( entity.getOwner() );
        lastUpdate = entity.getLastUpdate();
        description = entity.getDescription();
        exercise = exerciseToExerciseBasicInfoDTO( entity.getExercise() );
        solImage = imageToImageDTO( entity.getSolImage() );
        comments = commentListToCommentDTOList( entity.getComments() );

        SolutionDTO solutionDTO = new SolutionDTO( id, name, owner, lastUpdate, description, exercise, solImage, comments );

        return solutionDTO;
    }

    @Override
    public Solution toEntity(SolutionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Solution solution = new Solution();

        solution.setExercise( exerciseBasicInfoDTOToExercise( dto.exercise() ) );
        solution.setOwner( userBasicInfoDTOToUser( dto.owner() ) );
        solution.setName( dto.name() );
        solution.setDescription( dto.description() );
        solution.setLastUpdate( dto.lastUpdate() );
        solution.setSolImage( imageDTOToImage( dto.solImage() ) );
        solution.setComments( commentDTOListToCommentList( dto.comments() ) );

        return solution;
    }

    @Override
    public Solution toEntity(SolutionPostDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Solution solution = new Solution();

        solution.setName( dto.name() );
        solution.setDescription( dto.description() );

        return solution;
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

    protected ExerciseBasicInfoDTO exerciseToExerciseBasicInfoDTO(Exercise exercise) {
        if ( exercise == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String description = null;
        int numSolutions = 0;

        id = exercise.getId();
        title = exercise.getTitle();
        description = exercise.getDescription();
        numSolutions = exercise.getNumSolutions();

        ExerciseBasicInfoDTO exerciseBasicInfoDTO = new ExerciseBasicInfoDTO( id, title, description, numSolutions );

        return exerciseBasicInfoDTO;
    }

    protected ImageDTO imageToImageDTO(Image image) {
        if ( image == null ) {
            return null;
        }

        Long id = null;

        id = image.getId();

        ImageDTO imageDTO = new ImageDTO( id );

        return imageDTO;
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

    protected CommentDTO commentToCommentDTO(Comment comment) {
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

    protected List<CommentDTO> commentListToCommentDTOList(List<Comment> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentDTO> list1 = new ArrayList<CommentDTO>( list.size() );
        for ( Comment comment : list ) {
            list1.add( commentToCommentDTO( comment ) );
        }

        return list1;
    }

    protected Exercise exerciseBasicInfoDTOToExercise(ExerciseBasicInfoDTO exerciseBasicInfoDTO) {
        if ( exerciseBasicInfoDTO == null ) {
            return null;
        }

        Exercise exercise = new Exercise();

        exercise.setNumSolutions( exerciseBasicInfoDTO.numSolutions() );
        exercise.setTitle( exerciseBasicInfoDTO.title() );
        exercise.setDescription( exerciseBasicInfoDTO.description() );

        return exercise;
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

    protected Image imageDTOToImage(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        Image image = new Image();

        image.setId( imageDTO.id() );

        return image;
    }

    protected Solution solutionBasicInfoDTOToSolution(SolutionBasicInfoDTO solutionBasicInfoDTO) {
        if ( solutionBasicInfoDTO == null ) {
            return null;
        }

        Solution solution = new Solution();

        solution.setName( solutionBasicInfoDTO.name() );

        return solution;
    }

    protected Comment commentDTOToComment(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setText( commentDTO.text() );
        comment.setLastUpdate( commentDTO.lastUpdate() );
        comment.setOwner( userBasicInfoDTOToUser( commentDTO.owner() ) );
        comment.setSolution( solutionBasicInfoDTOToSolution( commentDTO.solution() ) );

        return comment;
    }

    protected List<Comment> commentDTOListToCommentList(List<CommentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Comment> list1 = new ArrayList<Comment>( list.size() );
        for ( CommentDTO commentDTO : list ) {
            list1.add( commentDTOToComment( commentDTO ) );
        }

        return list1;
    }
}
