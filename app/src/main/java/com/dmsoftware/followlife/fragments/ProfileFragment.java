package com.dmsoftware.followlife.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.dmsoftware.followlife.R;
import com.dmsoftware.followlife.adapters.ProfileAdapter;
import com.dmsoftware.followlife.model.Patient;
import com.dmsoftware.followlife.model.User;
import com.dmsoftware.followlife.networking.FollowLifeAPI;
import com.dmsoftware.followlife.viewModel.UserViewModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    User user;
    ImageView profileImageView;
    TextView nameTextView;
    TextView phoneTextView;
    TextView emailTextView;
    RecyclerView profileRecyclerView;
    ProfileAdapter profileAdapter;
    RecyclerView.LayoutManager profileLayoutManager;
    UserViewModel userViewModel;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        userViewModel = new UserViewModel();
        nameTextView = (TextView) view.findViewById(R.id.userNameTextView);
        phoneTextView = (TextView) view.findViewById(R.id.userNumberTextView);
        profileImageView = (ImageView) view.findViewById(R.id.userPhotoImageView);
        emailTextView = (TextView) view.findViewById(R.id.userEmailTextView);
        Bundle b = getArguments();
        getProfile(b.getString("session"));
        return view;
    }


    public void getProfile(String sessionToken) {

        AndroidNetworking.get(FollowLifeAPI.GET_PROFILE + "/1021")
                .addHeaders("X-FLLWLF-TOKEN",sessionToken)
                .addHeaders("Accept","application/json")
                .setTag("FollowLife")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("FollowLife","Success");

                        try {
                            nameTextView.setText(response.getString("firstName"));
                            phoneTextView.setText("966991826");
                            emailTextView.setText(response.getString("email"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(ANError anError) {
                        Log.d("FollowLife",anError.getLocalizedMessage());
                    }
                });
    }


}
