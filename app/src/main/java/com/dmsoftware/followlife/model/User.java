package com.dmsoftware.followlife.model;

import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private String session;

    public User(String id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String name, String lastName, String email) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
    }

    public String getSession() {
        return session;
    }

    public User setSession(String session) {
        this.session = session;
        return this;
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

    public static User from(Bundle bundle){
        User user = new User();
        user.setId(bundle.getString("id"))
                .setName(bundle.getString("name"))
                .setLastName(bundle.getString("lastName"))
                .setEmail(bundle.getString("email"))
                .setSession(bundle.getString("session"));
        return user;
    }

    public static Bundle toBundle(User user) {
        Bundle bundle = new Bundle();
        bundle.putString("id",user.getId());
        bundle.putString("name",user.getName());
        bundle.putString("lastName", user.getLastName());
        bundle.putString("session",user.getSession());
        bundle.putString("email",user.getEmail());
        return bundle;
    }

    public static User from(JSONObject json){
        User user = new User();
        try {
            user.setId(json.getString("Id"))
                    .setName(json.getString("FirstName"))
                    .setLastName(json.getString("LastName"))
                    .setEmail(json.getString("Email"))
                    .setSession(json.getString("SessionToken"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }

}
