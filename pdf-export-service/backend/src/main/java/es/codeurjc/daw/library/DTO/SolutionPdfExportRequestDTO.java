package es.codeurjc.daw.library.DTO;

public record SolutionPdfExportRequestDTO(
    SolutionPDFInfoDTO solution,
    ExerciseBasicInfoDTO exercise,
    byte[] pdfFile
) {

}