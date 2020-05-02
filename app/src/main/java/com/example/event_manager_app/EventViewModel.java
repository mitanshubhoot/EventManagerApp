package com.example.event_manager_app;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class EventViewModel extends AndroidViewModel {
    private EventRepository eventRepository;



    public EventViewModel(Application context )
    {
        super(context);
        eventRepository = new EventRepository(context );


    }

    public List<Event> getExploreEvents(List<String> codes)
    {

        return eventRepository.getExploreEvents(codes);

    }


    public List<Event> getEvents(List<String> codes)
    {

        return eventRepository.getEvents(codes);

    }

    public void insert(Event e)
    {
        eventRepository.insert(e);
    }



}
