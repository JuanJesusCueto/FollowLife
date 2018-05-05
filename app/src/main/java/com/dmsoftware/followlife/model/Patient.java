package com.dmsoftware.followlife.model;


import android.util.Log;

import org.json.JSONObject;

import org.json.JSONException;

public class Patient extends User {

    private String phoneNumber;
    private String sex;
    private String bloodType;
    private String height;
    private String weight;
    private String age;


    public Patient() {
    }



    public Patient(String name, String lastName, String email) {
        super(name, lastName, email);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Patient setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Patient setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getBloodType() {
        return bloodType;
    }

    public Patient setBloodType(String bloodType) {
        this.bloodType = bloodType;
        return this;
    }

    public String getHeight() {
        return height;
    }

    public Patient setHeight(String height) {
        this.height = height;
        return this;
    }

    public String getWeight() {
        return weight;
    }

    public Patient setWeight(String weight) {
        this.weight = weight;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Patient setAge(String age) {
        this.age = age;
        return this;
    }

    public static Patient from(JSONObject jsonObject) {
        try {
            Patient patientAux = new Patient(jsonObject.getString("firstName"),jsonObject.getString("lastName"),jsonObject.getString("email"));
            patientAux.setAge(jsonObject.getString("age"))
                    .setBloodType(jsonObject.getString("bloodType"))
                    .setHeight(jsonObject.getString("height"))
                    .setSex(jsonObject.getString("sex"))
                    .setWeight(jsonObject.getString("weight"))
                    .setPhoneNumber(jsonObject.getString("phoneNumber"));
            return patientAux;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }



}
