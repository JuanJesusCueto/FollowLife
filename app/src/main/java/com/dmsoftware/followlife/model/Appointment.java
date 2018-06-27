package com.dmsoftware.followlife.model;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

    public static Appointment from(Bundle bundle){
        Appointment appointment = new Appointment();
        appointment.setDoctorId(bundle.getInt("DoctorId"))
                .setPatientId(bundle.getInt("PatientId"))
                .setAppointmentDate(bundle.getString("AppointmentDate"))
                .setReason(bundle.getString("Reason"));
        return appointment;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("DoctorId", doctorId);
        bundle.putInt("PatientId",patientId);
        bundle.putString("AppointmentDate", appointmentDate);
        bundle.putString("Reason",reason);
        return bundle;
    }

    public static Appointment from(JSONObject json){
        Appointment appointment = new Appointment();
        try {
            appointment.setDoctorId(json.getInt("DoctorId"))
                    .setPatientId(json.getInt("PatientId"))
                    .setAppointmentDate(json.getString("AppointmentDate"))
                    .setReason(json.getString("Reason"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return appointment;
    }

    public static List<Appointment> from(JSONArray jsonSources) {
        List<Appointment> appointments = new ArrayList<>();
        for (int i = 0; i < jsonSources.length(); i++) {
            try {
                appointments.add(from(jsonSources.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return appointments;
    }
}
