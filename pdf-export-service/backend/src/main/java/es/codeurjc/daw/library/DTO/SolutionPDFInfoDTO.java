package es.codeurjc.daw.library.DTO;

import java.sql.Date;



public record SolutionPDFInfoDTO( Long id,
    String name, 
    UserBasicInfoDTO owner,
    Date lastUpdate,
    String description,
    ExerciseBasicInfoDTO exercise) {

    
}

  
