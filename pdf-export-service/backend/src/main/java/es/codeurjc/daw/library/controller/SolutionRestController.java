package es.codeurjc.daw.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;

import es.codeurjc.daw.library.DTO.SolutionPdfExportRequestDTO;
import es.codeurjc.daw.library.service.SolutionPdfExportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/solutions")
public class SolutionRestController {


    @Autowired
    private SolutionPdfExportService solutionPdfExportService;

    @PostMapping("/media/")
    public byte[] createSolutionPDF(@RequestBody SolutionPdfExportRequestDTO requestDTO) {
        try {
            byte[] pdfData = solutionPdfExportService.generateSolutionPdf(requestDTO.solution(), requestDTO.exercise(), requestDTO.pdfFile());
            return pdfData;
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to generate PDF: " + e.getMessage());
        }
    }

}
