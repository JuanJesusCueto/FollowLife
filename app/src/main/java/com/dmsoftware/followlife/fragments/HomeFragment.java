package com.dmsoftware.followlife.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dmsoftware.followlife.R;
import com.dmsoftware.followlife.adapters.NotificationAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView notificationsRecyclerView;
    NotificationAdapter notificationAdapter;
    RecyclerView.LayoutManager notificationLayoutManager;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        notificationsRecyclerView = (RecyclerView) view.findViewById(R.id.notificationsRecyclerView);
        notificationAdapter = new NotificationAdapter();
        notificationLayoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false);
        notificationsRecyclerView.setAdapter(notificationAdapter);
        notificationsRecyclerView.setLayoutManager(notificationLayoutManager);
        return view;
    }

}
