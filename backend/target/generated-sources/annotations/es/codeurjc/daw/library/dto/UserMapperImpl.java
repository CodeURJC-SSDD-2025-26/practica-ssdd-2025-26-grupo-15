package es.codeurjc.daw.library.dto;

import es.codeurjc.daw.library.model.ExerciseList;
import es.codeurjc.daw.library.model.Image;
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
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;
        String bio = null;
        String specialty = null;
        List<String> roles = null;
        List<ExerciseListBasicInfoDTO> exerciseLists = null;
        List<UserBasicInfoDTO> followers = null;
        List<UserBasicInfoDTO> following = null;
        List<UserBasicInfoDTO> requestedFriends = null;
        List<UserBasicInfoDTO> requestReceived = null;
        ImageDTO photo = null;

        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        bio = user.getBio();
        specialty = user.getSpecialty();
        List<String> list = user.getRoles();
        if ( list != null ) {
            roles = new ArrayList<String>( list );
        }
        exerciseLists = exerciseListListToExerciseListBasicInfoDTOList( user.getExerciseLists() );
        followers = toBasicInfoDTOs( user.getFollowers() );
        following = toBasicInfoDTOs( user.getFollowing() );
        requestedFriends = toBasicInfoDTOs( user.getRequestedFriends() );
        requestReceived = toBasicInfoDTOs( user.getRequestReceived() );
        photo = imageToImageDTO( user.getPhoto() );

        UserDTO userDTO = new UserDTO( id, name, email, bio, specialty, roles, exerciseLists, followers, following, requestedFriends, requestReceived, photo );

        return userDTO;
    }

    @Override
    public UserBasicInfoDTO toBasicInfoDTO(User user) {
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

    @Override
    public List<UserBasicInfoDTO> toBasicInfoDTOs(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserBasicInfoDTO> list = new ArrayList<UserBasicInfoDTO>( users.size() );
        for ( User user : users ) {
            list.add( toBasicInfoDTO( user ) );
        }

        return list;
    }

    @Override
    public User toDomain(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setRequestReceived( userBasicInfoDTOListToUserList( userDTO.requestReceived() ) );
        user.setRequestedFriends( userBasicInfoDTOListToUserList( userDTO.requestedFriends() ) );
        user.setBio( userDTO.bio() );
        user.setSpecialty( userDTO.specialty() );
        user.setId( userDTO.id() );
        user.setName( userDTO.name() );
        user.setEmail( userDTO.email() );
        List<String> list2 = userDTO.roles();
        if ( list2 != null ) {
            user.setRoles( new ArrayList<String>( list2 ) );
        }
        user.setPhoto( imageDTOToImage( userDTO.photo() ) );
        user.setExerciseLists( exerciseListBasicInfoDTOListToExerciseListList( userDTO.exerciseLists() ) );
        if ( user.getFollowing() != null ) {
            List<User> list4 = userBasicInfoDTOListToUserList( userDTO.following() );
            if ( list4 != null ) {
                user.getFollowing().addAll( list4 );
            }
        }
        if ( user.getFollowers() != null ) {
            List<User> list5 = userBasicInfoDTOListToUserList( userDTO.followers() );
            if ( list5 != null ) {
                user.getFollowers().addAll( list5 );
            }
        }

        return user;
    }

    @Override
    public User toEntity(UserLoginDTO userLoginDTO) {
        if ( userLoginDTO == null ) {
            return null;
        }

        User user = new User();

        user.setName( userLoginDTO.name() );
        user.setEmail( userLoginDTO.email() );
        user.setEncodedPassword( userLoginDTO.encodedPassword() );

        return user;
    }

    @Override
    public User fromUserEditDTOtoEntity(UserEditDTO userEditDTO) {
        if ( userEditDTO == null ) {
            return null;
        }

        User user = new User();

        user.setBio( userEditDTO.bio() );
        user.setSpecialty( userEditDTO.specialty() );
        user.setName( userEditDTO.name() );
        user.setPhoto( imageDTOToImage( userEditDTO.photo() ) );

        return user;
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

    protected List<ExerciseListBasicInfoDTO> exerciseListListToExerciseListBasicInfoDTOList(List<ExerciseList> list) {
        if ( list == null ) {
            return null;
        }

        List<ExerciseListBasicInfoDTO> list1 = new ArrayList<ExerciseListBasicInfoDTO>( list.size() );
        for ( ExerciseList exerciseList : list ) {
            list1.add( exerciseListToExerciseListBasicInfoDTO( exerciseList ) );
        }

        return list1;
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

    protected List<User> userBasicInfoDTOListToUserList(List<UserBasicInfoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<User> list1 = new ArrayList<User>( list.size() );
        for ( UserBasicInfoDTO userBasicInfoDTO : list ) {
            list1.add( userBasicInfoDTOToUser( userBasicInfoDTO ) );
        }

        return list1;
    }

    protected Image imageDTOToImage(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        Image image = new Image();

        image.setId( imageDTO.id() );

        return image;
    }

    protected ExerciseList exerciseListBasicInfoDTOToExerciseList(ExerciseListBasicInfoDTO exerciseListBasicInfoDTO) {
        if ( exerciseListBasicInfoDTO == null ) {
            return null;
        }

        ExerciseList exerciseList = new ExerciseList();

        exerciseList.setTitle( exerciseListBasicInfoDTO.title() );

        return exerciseList;
    }

    protected List<ExerciseList> exerciseListBasicInfoDTOListToExerciseListList(List<ExerciseListBasicInfoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<ExerciseList> list1 = new ArrayList<ExerciseList>( list.size() );
        for ( ExerciseListBasicInfoDTO exerciseListBasicInfoDTO : list ) {
            list1.add( exerciseListBasicInfoDTOToExerciseList( exerciseListBasicInfoDTO ) );
        }

        return list1;
    }
}
