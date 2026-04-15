package es.codeurjc.daw.library.dto;

import es.codeurjc.daw.library.model.Exercise;
import es.codeurjc.daw.library.model.ExerciseList;
import es.codeurjc.daw.library.model.Solution;
import es.codeurjc.daw.library.model.User;
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
public class ExerciseMapperImpl implements ExerciseMapper {

    @Override
    public ExerciseDTO toDTO(Exercise exercise) {
        if ( exercise == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String description = null;
        int numSolutions = 0;
        UserBasicInfoDTO owner = null;
        ExerciseListBasicInfoDTO exerciseList = null;
        List<SolutionBasicInfoDTO> solutions = null;

        id = exercise.getId();
        title = exercise.getTitle();
        description = exercise.getDescription();
        numSolutions = exercise.getNumSolutions();
        owner = userToUserBasicInfoDTO( exercise.getOwner() );
        exerciseList = exerciseListToExerciseListBasicInfoDTO( exercise.getExerciseList() );
        solutions = solutionListToSolutionBasicInfoDTOList( exercise.getSolutions() );

        ExerciseDTO exerciseDTO = new ExerciseDTO( id, title, description, numSolutions, owner, exerciseList, solutions );

        return exerciseDTO;
    }

    @Override
    public Exercise toEntity(ExerciseDTO exerciseDTO) {
        if ( exerciseDTO == null ) {
            return null;
        }

        Exercise exercise = new Exercise();

        exercise.setExerciseList( exerciseListBasicInfoDTOToExerciseList( exerciseDTO.exerciseList() ) );
        exercise.setSolutions( solutionBasicInfoDTOListToSolutionList( exerciseDTO.solutions() ) );
        exercise.setNumSolutions( exerciseDTO.numSolutions() );
        exercise.setTitle( exerciseDTO.title() );
        exercise.setDescription( exerciseDTO.description() );
        exercise.setOwner( userBasicInfoDTOToUser( exerciseDTO.owner() ) );

        return exercise;
    }

    @Override
    public Exercise toEntity(ExercisePostDTO exercisePostDTO) {
        if ( exercisePostDTO == null ) {
            return null;
        }

        Exercise exercise = new Exercise();

        exercise.setTitle( exercisePostDTO.title() );
        exercise.setDescription( exercisePostDTO.description() );

        return exercise;
    }

    @Override
    public Exercise toEntity(ExercisePutDTO exercisePutDTO) {
        if ( exercisePutDTO == null ) {
            return null;
        }

        Exercise exercise = new Exercise();

        exercise.setTitle( exercisePutDTO.title() );
        exercise.setDescription( exercisePutDTO.description() );

        return exercise;
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

    protected ExerciseListBasicInfoDTO exerciseListToExerciseListBasicInfoDTO(ExerciseList exerciseList) {
        if ( exerciseList == null ) {
            return null;
        }

        Long id = null;
        String title = null;

        id = exerciseList.getId();
        title = exerciseList.getTitle();

        ExerciseListBasicInfoDTO exerciseListBasicInfoDTO = new ExerciseListBasicInfoDTO( id, title );

        return exerciseListBasicInfoDTO;
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

    protected List<SolutionBasicInfoDTO> solutionListToSolutionBasicInfoDTOList(List<Solution> list) {
        if ( list == null ) {
            return null;
        }

        List<SolutionBasicInfoDTO> list1 = new ArrayList<SolutionBasicInfoDTO>( list.size() );
        for ( Solution solution : list ) {
            list1.add( solutionToSolutionBasicInfoDTO( solution ) );
        }

        return list1;
    }

    protected ExerciseList exerciseListBasicInfoDTOToExerciseList(ExerciseListBasicInfoDTO exerciseListBasicInfoDTO) {
        if ( exerciseListBasicInfoDTO == null ) {
            return null;
        }

        ExerciseList exerciseList = new ExerciseList();

        exerciseList.setTitle( exerciseListBasicInfoDTO.title() );

        return exerciseList;
    }

    protected Solution solutionBasicInfoDTOToSolution(SolutionBasicInfoDTO solutionBasicInfoDTO) {
        if ( solutionBasicInfoDTO == null ) {
            return null;
        }

        Solution solution = new Solution();

        solution.setName( solutionBasicInfoDTO.name() );

        return solution;
    }

    protected List<Solution> solutionBasicInfoDTOListToSolutionList(List<SolutionBasicInfoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Solution> list1 = new ArrayList<Solution>( list.size() );
        for ( SolutionBasicInfoDTO solutionBasicInfoDTO : list ) {
            list1.add( solutionBasicInfoDTOToSolution( solutionBasicInfoDTO ) );
        }

        return list1;
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
}
