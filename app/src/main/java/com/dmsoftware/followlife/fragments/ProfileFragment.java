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

import com.dmsoftware.followlife.R;
import com.dmsoftware.followlife.adapters.ProfileAdapter;
import com.dmsoftware.followlife.model.Patient;
import com.dmsoftware.followlife.model.User;
import com.dmsoftware.followlife.viewModel.UserViewModel;

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
        Bundle b = getArguments();
        Patient patient = userViewModel.getProfile(b.getString("session"));
        Log.d("FollowLife",patient.getName());
        if (patient != null) {
            patient.setPhoneNumber("966991826");
            nameTextView.setText(patient.getName());
            phoneTextView.setText(patient.getPhoneNumber());
            emailTextView.setText(patient.getEmail());
        }
        return view;
    }

}
