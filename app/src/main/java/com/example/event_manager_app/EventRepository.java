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
    public boolean isValidEventCode(String ev)
    {
        String event_code = null;
        try{
            event_code = eventDao.checkEventCode(ev);
        }
        catch (RuntimeException r)
        {

        }
        if(event_code==null )
            return false;
        return true;
    }

    public void insert(Event e)
    {
        eventDao.insert(e);
    }


}

