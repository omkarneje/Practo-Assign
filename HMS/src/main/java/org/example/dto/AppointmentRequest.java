package org.example.dto;

import org.example.entity.Appointment;

import java.time.LocalDateTime;

public class AppointmentRequest {
    private LocalDateTime appointmentDate;
    private String status;
    private Long patientId;
    private Long doctorId;

    // Getters and Setters

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Appointment toAppointment() {
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(this.appointmentDate);
        appointment.setStatus(this.status);
        return appointment;
    }
}
