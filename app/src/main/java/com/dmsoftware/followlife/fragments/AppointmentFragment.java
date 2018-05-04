package com.dmsoftware.followlife.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmsoftware.followlife.R;
import com.dmsoftware.followlife.adapters.AppointmentAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentFragment extends Fragment {

    RecyclerView appointmentRecyclerView;
    AppointmentAdapter appointmentAdapter;
    RecyclerView.LayoutManager appointmentLayoutManager;
    FloatingActionButton addAppointment;

    public AppointmentFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);
        appointmentAdapter = new AppointmentAdapter();
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
        return view;
    }

}
