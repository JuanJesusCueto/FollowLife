package com.dmsoftware.followlife.viewModel;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.dmsoftware.followlife.model.Patient;
import com.dmsoftware.followlife.model.User;
import com.dmsoftware.followlife.networking.FollowLifeAPI;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class UserViewModel extends ViewModel {

    private User user;
    private String message;

    public UserViewModel() {
    }

    public User login(String email, String password, String deviceToken) {

        JSONObject model = new JSONObject();


        try {
            model.put("Email", email);
            model.put("Password", password);
            model.put("DeviceToken", deviceToken);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(FollowLifeAPI.PATIENT_LOGIN)
                .addJSONObjectBody(model)
                .setTag("FollowLife")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if ("success".equalsIgnoreCase(response.getString("Message"))) {
                                //Log.d("FollowLife",response.getJSONObject("Result").getString("SessionToken"));
                                user = new User();
                                user = user.from(response.getJSONObject("Result"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("FollowLife",anError.getLocalizedMessage());
                    }
                });
        return user;
    }

    public String signUp(String firstName, String lastName, String email, String pass) {

        JSONObject model = new JSONObject();

        try {
            model.put("FirstName",firstName);
            model.put("LastName",lastName);
            model.put("Email",email);
            model.put("Password",pass);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(FollowLifeAPI.SIGN_UP)
                .addJSONObjectBody(model)
                .setTag("FollowLife")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if ("success".equalsIgnoreCase(response.getString("Message"))); {
                                message = "success";
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("FollowLife",anError.getLocalizedMessage());
                        message = anError.getLocalizedMessage();
                    }
                });

        return message;
    }
}
