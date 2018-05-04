package com.dmsoftware.followlife.model;


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
        Patient patient = new Patient("","","");
        try {
            patient = new Patient(jsonObject.getString("FirstName"),jsonObject.getString("LastName"),jsonObject.getString("Email"));
            patient.setAge(jsonObject.getString("Age"))
                    .setBloodType(jsonObject.getString("BloodType"))
                    .setHeight(jsonObject.getString("Height"))
                    .setSex(jsonObject.getString("Sex"))
                    .setWeight(jsonObject.getString("Weight"))
                    .setPhoneNumber(jsonObject.getString("PhoneNumber"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return patient;
    }

}
