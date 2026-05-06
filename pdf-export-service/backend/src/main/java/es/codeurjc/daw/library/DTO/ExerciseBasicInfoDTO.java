package es.codeurjc.daw.library.DTO;

public record ExerciseBasicInfoDTO (
    Long id,
    String title,
    String description,
    int numSolutions
) {}
