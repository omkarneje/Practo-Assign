package org.example.controller;

import org.example.entity.ConsultationNote;
import org.example.service.ConsultationNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation-notes")
@CrossOrigin(origins = "http://localhost:3000")
public class ConsultationNoteController {
    @Autowired
    private ConsultationNoteService consultationNoteService;

    // Endpoint to get all consultation notes for a specific doctor
    @GetMapping("/doctor/{doctorId}")
    public List<ConsultationNote> getAllConsultationNotesForDoctor(@PathVariable Long doctorId) {
        return consultationNoteService.getAllConsultationNotesForDoctor(doctorId);
    }

    // Endpoint to add a consultation note for a specific doctor and patient
    @PostMapping("/doctor/{doctorId}/patient/{patientId}")
    public ConsultationNote addConsultationNoteForDoctor(
            @PathVariable Long doctorId,
            @PathVariable Long patientId,
            @RequestBody ConsultationNote consultationNote
    ) {
        return consultationNoteService.addConsultationNoteForDoctor(doctorId, patientId, consultationNote);
    }

    // Endpoint to update a consultation note for a specific doctor
    @PutMapping("/doctor/{doctorId}/consultation-note/{consultationNoteId}")
    public ConsultationNote updateConsultationNoteForDoctor(
            @PathVariable Long doctorId,
            @PathVariable Long consultationNoteId,
            @RequestBody ConsultationNote consultationNote
    ) {
        return consultationNoteService.updateConsultationNoteForDoctor(doctorId, consultationNoteId, consultationNote);
    }

    // Endpoint to delete a consultation note for a specific doctor
    @DeleteMapping("/doctor/{doctorId}/consultation-note/{consultationNoteId}")
    public void deleteConsultationNoteForDoctor(
            @PathVariable Long doctorId,
            @PathVariable Long consultationNoteId
    ) {
        consultationNoteService.deleteConsultationNoteForDoctor(doctorId, consultationNoteId);
    }
}
