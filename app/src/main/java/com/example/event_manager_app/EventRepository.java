package com.example.event_manager_app;

import android.app.Application;

import java.util.List;

public class EventRepository {
    private final EventDao eventDao;

    public EventRepository(Application context )
    {
        EventDatabase database = EventDatabase.getEventDatabase(context);
        eventDao = database.EventDao();

    }

    public List<Event> getEvents(List<String> codes)
    {
        return eventDao.getEvents(codes);
    }
    public List<Event> getExploreEvents(List<String> codes , String t)
    {
        return eventDao.getExploreEvents(codes , t);
    }

    public void insert(Event e)
    {
        eventDao.insert(e);
    }


}

