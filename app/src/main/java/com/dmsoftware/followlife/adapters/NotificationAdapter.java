package com.dmsoftware.followlife.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dmsoftware.followlife.R;
import com.dmsoftware.followlife.repositories.NotificationsRepository;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    public NotificationAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_notification,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final String description = NotificationsRepository.notificationMessages.get(position);
        holder.descriptionTextView.setText(description);
    }

    @Override
    public int getItemCount() {
        return NotificationsRepository.notificationMessages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView descriptionTextView;
        TextView declineTextView;
        TextView afirmationTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            declineTextView = (TextView) itemView.findViewById(R.id.notTextView);
            descriptionTextView = (TextView) itemView.findViewById(R.id.notificationBodyTextView);
            afirmationTextView = (TextView) itemView.findViewById(R.id.afirmationTextView);
        }
    }
}
