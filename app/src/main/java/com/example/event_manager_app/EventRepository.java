package com.example.event_manager_app;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class EventRepository {
    private final EventDao eventDao;
    private static EventRepository instance;
    private LiveData<Event> participantEventData;

    public EventRepository(Application context)
    {
        EventDatabase database = EventDatabase.getEventDatabase(context);
    }

    public static EventRepository getInstance(EventDao eventDao)
    {
        if(instance == null)
        {
            instance = new EventRepository(eventDao);
        }
        return instance;
    }
    public LiveData<List<Event>> getAllEvents(List<String> codes)
    {
        return eventDao.getAllEvents(codes);
    }
    public void insert(Event e)
    {
        eventDao.insert(e);
    }
}
