package com.dmsoftware.followlife.model;

public class Patient extends User {

    private String phoneNumber;
    private String sex;
    private String bloodType;
    private String height;
    private String weight;
    private String age;

    public Patient(String id, String name, String lastName, String email, String password, String phoneNumber, String sex, String bloodType, String height, String weight, String age) {
        super(id, name, lastName, email, password);
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.bloodType = bloodType;
        this.height = height;
        this.weight = weight;
        this.age = age;
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
}
