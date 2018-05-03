package com.dmsoftware.followlife.model;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    public User(String id, String name, String lastName, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public static User from(Bundle bundle){
        User user = new User();
        user.setId(bundle.getString("id"))
                .setName(bundle.getString("name"))
                .setLastName(bundle.getString("lastName"))
                .setEmail(bundle.getString("email"))
                .setPassword(bundle.getString("password"));
        return user;
    }

    public static User from(JSONObject json){
        User user = new User();
        try {
            user.setId(json.getString("petId"))
                    .setName(json.getString("name"))
                    .setLastName(json.getString("lastNmae"))
                    .setEmail(json.getString("email"))
                    .setPassword(json.getString("password"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

}
