package es.codeurjc.daw.library.dto;

import es.codeurjc.daw.library.model.Exercise;
import es.codeurjc.daw.library.model.ExerciseList;
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
public class ExerciseListMapperImpl implements ExerciseListMapper {

    @Override
    public ExerciseListDTO toDTO(ExerciseList exerciseList) {
        if ( exerciseList == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String description = null;
        String topic = null;
        Date lastUpdate = null;
        UserBasicInfoDTO owner = null;
        List<ExerciseBasicInfoDTO> exercises = null;

        id = exerciseList.getId();
        title = exerciseList.getTitle();
        description = exerciseList.getDescription();
        topic = exerciseList.getTopic();
        lastUpdate = exerciseList.getLastUpdate();
        owner = userToUserBasicInfoDTO( exerciseList.getOwner() );
        exercises = exerciseListToExerciseBasicInfoDTOList( exerciseList.getExercises() );

        ExerciseListDTO exerciseListDTO = new ExerciseListDTO( id, title, description, topic, lastUpdate, owner, exercises );

        return exerciseListDTO;
    }

    @Override
    public ExerciseList toEntity(ExerciseListDTO exerciseListDTO) {
        if ( exerciseListDTO == null ) {
            return null;
        }

        ExerciseList exerciseList = new ExerciseList();

        exerciseList.setOwner( userBasicInfoDTOToUser( exerciseListDTO.owner() ) );
        exerciseList.setLastUpdate( exerciseListDTO.lastUpdate() );
        exerciseList.setTitle( exerciseListDTO.title() );
        exerciseList.setDescription( exerciseListDTO.description() );
        exerciseList.setTopic( exerciseListDTO.topic() );
        exerciseList.setExercises( exerciseBasicInfoDTOListToExerciseList( exerciseListDTO.exercises() ) );

        return exerciseList;
    }

    @Override
    public ExerciseList toEntity(ExerciseListPostDTO exerciseListPostDTO) {
        if ( exerciseListPostDTO == null ) {
            return null;
        }

        ExerciseList exerciseList = new ExerciseList();

        exerciseList.setTitle( exerciseListPostDTO.title() );
        exerciseList.setDescription( exerciseListPostDTO.description() );
        exerciseList.setTopic( exerciseListPostDTO.topic() );

        return exerciseList;
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

    protected List<ExerciseBasicInfoDTO> exerciseListToExerciseBasicInfoDTOList(List<Exercise> list) {
        if ( list == null ) {
            return null;
        }

        List<ExerciseBasicInfoDTO> list1 = new ArrayList<ExerciseBasicInfoDTO>( list.size() );
        for ( Exercise exercise : list ) {
            list1.add( exerciseToExerciseBasicInfoDTO( exercise ) );
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

    protected List<Exercise> exerciseBasicInfoDTOListToExerciseList(List<ExerciseBasicInfoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Exercise> list1 = new ArrayList<Exercise>( list.size() );
        for ( ExerciseBasicInfoDTO exerciseBasicInfoDTO : list ) {
            list1.add( exerciseBasicInfoDTOToExercise( exerciseBasicInfoDTO ) );
        }

        return list1;
    }
}
