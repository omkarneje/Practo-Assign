package org.example.repository;

import org.example.entity.ConsultationNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultationNoteRepository extends JpaRepository<ConsultationNote, Long> {
    List<ConsultationNote> findByDoctorId(Long doctorId);
    Optional<ConsultationNote> findByIdAndDoctorId(Long id, Long doctorId);
}
