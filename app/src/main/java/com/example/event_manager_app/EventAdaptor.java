package com.example.event_manager_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class EventAdaptor extends RecyclerView.Adapter<EventAdaptor.ViewHolder> {
    private List<Event> events = new ArrayList<>();
    @NonNull
    @Override
    public EventAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext() )
                .inflate(R.layout.layout_event , parent , false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdaptor.ViewHolder holder, int position) {
        Event event = events.get(position);
        holder.event_name.setText(event.getEvent_name());
        holder.event_date.setText(event.getDate());
    }
    public void setEvents(List<Event> events)
    {
        this.events =events;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView event_name;
        public TextView event_date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            event_name = (TextView) itemView.findViewById(R.id.event_name_l);
            event_date = (TextView) itemView.findViewById(R.id.date_l);
        }
    }
}
