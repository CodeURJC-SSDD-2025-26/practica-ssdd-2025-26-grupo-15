package es.codeurjc.daw.library.dto;

import java.util.Date;

public record SolutionPDFInfoDTO( Long id,
    String name, 
    UserBasicInfoDTO owner,
    Date lastUpdate,
    String description,
    ExerciseBasicInfoDTO exercise) {

    
}
