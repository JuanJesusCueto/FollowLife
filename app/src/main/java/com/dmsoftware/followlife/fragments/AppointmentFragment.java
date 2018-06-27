package com.dmsoftware.followlife.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.dmsoftware.followlife.R;
import com.dmsoftware.followlife.adapters.AppointmentAdapter;
import com.dmsoftware.followlife.model.Appointment;
import com.dmsoftware.followlife.networking.FollowLifeAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentFragment extends Fragment {

    RecyclerView appointmentRecyclerView;
    AppointmentAdapter appointmentAdapter;
    RecyclerView.LayoutManager appointmentLayoutManager;
    FloatingActionButton addAppointment;
    List<Appointment> appointments;

    public AppointmentFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);
        Bundle b = getArguments();
        appointments = new ArrayList<>();
        appointmentAdapter = new AppointmentAdapter(appointments);
        appointmentRecyclerView = (RecyclerView) view.findViewById(R.id.appointmentRecyclerView);
        addAppointment = (FloatingActionButton) view.findViewById(R.id.addAppointment);
        appointmentLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        appointmentRecyclerView.setAdapter(appointmentAdapter);
        appointmentRecyclerView.setLayoutManager(appointmentLayoutManager);
        addAppointment.setOnContextClickListener(new View.OnContextClickListener() {
            @Override
            public boolean onContextClick(View v) {
                return false;
            }
        });
        getAppointments(b.getInt("id"),b.getString("session") );
        return view;
    }

    void getAppointments(int id, String token) {
        String url = FollowLifeAPI.APPOINTMENTS + "/1021" + "/appointments";
        Log.d("FollowLife",url);
        AndroidNetworking.get(FollowLifeAPI.APPOINTMENTS + "/" + Integer.toString(id) + "/appointments")
                .addHeaders("X-FLLWLF-TOKEN",token)
                .addHeaders("Content-Type","application/json")
                .setTag("FollowLife")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("FollowLife","Success");

                        try {
                            if ("ok".equalsIgnoreCase(response.getString("Status"))) {
                                appointments = Appointment.from(response.getJSONArray("Result"));
                                appointmentAdapter.setAppointments(appointments);
                                appointmentAdapter.notifyDataSetChanged();
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
    }
}
