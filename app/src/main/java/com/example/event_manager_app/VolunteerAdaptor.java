package com.example.event_manager_app;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class VolunteerAdaptor extends RecyclerView.Adapter<VolunteerAdaptor.MyViewHolder>{
    private List<Volunteer> volunteers = new ArrayList<>();
    private onItemClickListener listener;


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext() )
                .inflate(R.layout.layout_volunteer , parent , false);
        return new VolunteerAdaptor.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Volunteer volunteer = volunteers.get(position);
        holder.name.setText(volunteer.getName());
        holder.no_hours_publicity.setText(String.valueOf(volunteer.getNoOfHoursPublicity()));
    }



    @Override
    public int getItemCount() {
        return volunteers.size();
    }

    public void setVolunteers(List<Volunteer> volunteers)
    {
        this.volunteers = volunteers;
        notifyDataSetChanged();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name ;
        private TextView no_hours_publicity;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.volu_name);
            no_hours_publicity= itemView.findViewById(R.id.no_of_participant);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(volunteers.get(position));
                        Log.d("Volunteers" , "volunteer selected"+volunteers.get(position).getName());

                    }
                }
            });


        }
    }


    public interface onItemClickListener {
        void onItemClick(Volunteer volunteer);
    }

    public void setOnItemClickListener( onItemClickListener listener) {
        this.listener = listener;
    }
}


