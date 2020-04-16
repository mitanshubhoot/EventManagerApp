package com.example.event_manager_app;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EventRepository {
    private final EventDao eventDao;
    private LiveData<List<Event>> participantEventData;

    public EventRepository(Application context )
    {
        EventDatabase database = EventDatabase.getEventDatabase(context);
        eventDao = database.EventDao();

    }

    /*public static EventRepository getInstance(EventDao eventDao)
    {
        if(instance == null)
        {
            instance = new EventRepository(eventDao);
        }
        return instance;
    }*/
    public LiveData<List<Event>> getAllEvents(List<String> codes)
    {
        participantEventData = eventDao.getAllEvents(codes);
        return participantEventData;
    }

    public LiveData<List<Event>> getEvents(String email)
    {
        return eventDao.getEvents(email);
    }
    public void insert(Event e)
    {
        eventDao.insert(e);
    }

    public List<Event> getInitialStatus()
    {
        return eventDao.getInitialStatus();
    }
}
