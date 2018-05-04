package com.dmsoftware.followlife.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dmsoftware.followlife.R;
import com.dmsoftware.followlife.model.Appointment;
import com.dmsoftware.followlife.repositories.AppointmentRespository;

import java.util.List;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder>{

    private List<Appointment> appointments;

    public AppointmentAdapter(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public AppointmentAdapter() {
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public AppointmentAdapter setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
        return this;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_appointment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Appointment appointment = AppointmentRespository.appointmentList.get(position);
        holder.scheduleTextView.setText(appointment.getAppointmentDate());
        holder.doctorTextView.setText("Luis");
        holder.detailImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return AppointmentRespository.appointmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView scheduleTextView;
        TextView doctorTextView;
        ImageButton detailImageButton;

        public ViewHolder(View itemView) {
            super(itemView);
            scheduleTextView = (TextView) itemView.findViewById(R.id.scheduleTextView);
            doctorTextView = (TextView) itemView.findViewById(R.id.doctorTextView);
            detailImageButton = (ImageButton) itemView.findViewById(R.id.detailButton);
        }
    }
}
