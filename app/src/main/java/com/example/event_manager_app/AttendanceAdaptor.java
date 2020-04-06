package com.example.event_manager_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AttendanceAdaptor extends RecyclerView.Adapter<AttendanceAdaptor.MyViewHolder>{
    private List<Participant> partcipants = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext() )
                .inflate(R.layout.layout_participant, parent , false);
        return new AttendanceAdaptor.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Participant participant = partcipants.get(position);
        holder.email.setText(participant.getEmail());

    }

    @Override
    public int getItemCount() {
        return partcipants.size();
    }

    public void setPartcipants(List<Participant> partcipants)
    {
        this.partcipants = partcipants;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView email ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.participant_email);


        }
    }
}

