package com.example.event_manager_app;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class EventViewModel extends AndroidViewModel {
    private EventRepository eventRepository;
    private MutableLiveData<List<Event>> eventsLiveData ;


    public EventViewModel(Application context )
    {
        super(context);
        eventRepository = new EventRepository(context );
        eventsLiveData = new MutableLiveData<>() ;

    }

    public MutableLiveData<List<Event>> getEventsLiveData() {
        return eventsLiveData;
    }

    public void setEventsLiveData(MutableLiveData<List<Event>> eventsLiveData) {
        this.eventsLiveData = eventsLiveData;
    }


     public LiveData<List<Event>> getAllEvents(List<String> codes)
     {
         if(eventsLiveData == null){
             eventsLiveData = new MutableLiveData<>() ;
             eventsLiveData = (MutableLiveData<List<Event>>)eventRepository.getAllEvents(codes);
         }
         return eventsLiveData;

     }

     public void insert(Event e)
     {
         eventRepository.insert(e);
     }

     public List<Event> getInitialStatus()
     {
         return eventRepository.getInitialStatus();
     }


}
