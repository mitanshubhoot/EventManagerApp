package com.example.event_manager_app;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AttendanceAdaptor extends RecyclerView.Adapter<AttendanceAdaptor.MyViewHolder>{
    private List<Participant> partcipants = new ArrayList<>();
    private onCheckBoxClickListener listener;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext() )
                .inflate(R.layout.layout_participant, parent , false);
        return new AttendanceAdaptor.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Participant participant = partcipants.get(position);
        holder.email.setText(participant.getEmail());
       //in some cases, it will prevent unwanted situations
        holder.attendance.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
        holder.attendance.setChecked(partcipants.get(position).isAttendance());

        holder.attendance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                partcipants.get(holder.getAdapterPosition()).setAttendance(isChecked);

            }
        });



    }

    @Override
    public int getItemCount() {
        return partcipants.size();
    }

    public void setParticipants(List<Participant> partcipants)
    {
        this.partcipants = partcipants;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView email ;
        private CheckBox attendance;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.participant_email);
            attendance = itemView.findViewById(R.id.check_box);
            attendance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener!=null && position!=RecyclerView.NO_POSITION)
                    {
                        listener.onCheckBoxClick(attendance.isChecked() , partcipants.get(position).getId());
                        Log.d("Participant" , " selected"+partcipants.get(position).getName());

                    }

                }
            });



        }
    }
    public interface onCheckBoxClickListener{
        void onCheckBoxClick(boolean attendance , int id);
    }

    public void setOnCheckBoxClickListener(onCheckBoxClickListener listener){
        this.listener = listener;

    }
}

