package org.example.service;

import org.example.entity.ConsultationNote;
import org.example.repository.ConsultationNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationNoteService {
    @Autowired
    private ConsultationNoteRepository consultationNoteRepository;

    public List<ConsultationNote> getAllConsultationNotesForDoctor(Long doctorId) {
        return consultationNoteRepository.findByDoctorId(doctorId);
    }

    public ConsultationNote addConsultationNoteForDoctor(Long doctorId, Long patientId, ConsultationNote consultationNote) {
        consultationNote.setDoctorId(doctorId);
        consultationNote.setPatientId(patientId);
        return consultationNoteRepository.save(consultationNote);
    }

    public ConsultationNote updateConsultationNoteForDoctor(Long doctorId, Long consultationNoteId, ConsultationNote consultationNote) {
        ConsultationNote existingNote = consultationNoteRepository.findByIdAndDoctorId(consultationNoteId, doctorId)
                .orElseThrow(() -> new RuntimeException("Consultation Note not found"));
        existingNote.setNote(consultationNote.getNote());
        return consultationNoteRepository.save(existingNote);
    }

    public void deleteConsultationNoteForDoctor(Long doctorId, Long consultationNoteId) {
        ConsultationNote existingNote = consultationNoteRepository.findByIdAndDoctorId(consultationNoteId, doctorId)
                .orElseThrow(() -> new RuntimeException("Consultation Note not found"));
        consultationNoteRepository.delete(existingNote);
    }
}
