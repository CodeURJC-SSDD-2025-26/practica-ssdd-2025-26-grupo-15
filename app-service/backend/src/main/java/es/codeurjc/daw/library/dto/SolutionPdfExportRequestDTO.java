package es.codeurjc.daw.library.dto;

public record SolutionPdfExportRequestDTO(
    SolutionPDFInfoDTO solution,
    ExerciseBasicInfoDTO exercise,
    byte[] pdfFile
) {

}