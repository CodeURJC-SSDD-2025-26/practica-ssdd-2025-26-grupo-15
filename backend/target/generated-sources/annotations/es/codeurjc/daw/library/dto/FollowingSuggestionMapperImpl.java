package es.codeurjc.daw.library.dto;

import es.codeurjc.daw.library.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-15T23:43:15+0200",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class FollowingSuggestionMapperImpl implements FollowingSuggestionMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public FollowingSuggestionDTO toDTO(UserService.UserPair userPair) {
        if ( userPair == null ) {
            return null;
        }

        UserBasicInfoDTO suggestion = null;
        List<UserBasicInfoDTO> contact = null;

        suggestion = userMapper.toBasicInfoDTO( userPair.suggestion() );
        contact = userMapper.toBasicInfoDTOs( userPair.contact() );

        int commonCount = userPair.getCommonCount();

        FollowingSuggestionDTO followingSuggestionDTO = new FollowingSuggestionDTO( suggestion, contact, commonCount );

        return followingSuggestionDTO;
    }

    @Override
    public List<FollowingSuggestionDTO> toDTOs(List<UserService.UserPair> userPairs) {
        if ( userPairs == null ) {
            return null;
        }

        List<FollowingSuggestionDTO> list = new ArrayList<FollowingSuggestionDTO>( userPairs.size() );
        for ( UserService.UserPair userPair : userPairs ) {
            list.add( toDTO( userPair ) );
        }

        return list;
    }
}
