package com.dmsoftware.followlife.model;

public class Appointment {
    private int patientId;
    private int doctorId;
    private String appointmentDate;
    private String reason;

    public Appointment() {
    }

    public Appointment(int patientId, int doctorId, String appointmentDate, String reason) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.reason = reason;
    }

    public int getPatientId() {
        return patientId;
    }

    public Appointment setPatientId(int patientId) {
        this.patientId = patientId;
        return this;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public Appointment setDoctorId(int doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public Appointment setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public Appointment setReason(String reason) {
        this.reason = reason;
        return this;
    }
}
