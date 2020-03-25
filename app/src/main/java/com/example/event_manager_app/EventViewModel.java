package com.example.event_manager_app;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

public class EventViewModel extends AndroidViewModel {
    private EventRepository eventRepository;
    private MutableLiveData<List<Event>> eventsLiveData ;
    private List<Event> events ;

    public EventViewModel(Application context)
    {
        super(context);
        eventRepository = new EventRepository(context);
        eventsLiveData = new MutableLiveData<>() ;
        init();

    }

    public MutableLiveData<List<Event>> getEventsLiveData() {
        return eventsLiveData;
    }

    public void setEventsLiveData(MutableLiveData<List<Event>> eventsLiveData) {
        this.eventsLiveData = eventsLiveData;
    }

    public void init(){
        populateList();
        eventsLiveData.setValue(events);
    }

    public void populateList(){

       Event e1 = new Event("TC-01","Hackathon","oswalsakshi17@gmail.com",70000 , 50000 , 400 , "12/9/2020","Room : 1323A" , "Technical");
        Event e2 = new Event("TC-02","Competetive-Coding","oswalsakshi17@gmail.com",90000 , 30000 , 200 , "15/9/2020","Room : 1324D" , "Technical");
        events = new ArrayList<>();
        events.add(e1);
        events.add(e2);
    }

     public LiveData<List<Event>> getAllEvents(List<String> codes)
     {
         if(eventsLiveData == null){
             eventsLiveData = new MutableLiveData<>() ;
             eventsLiveData = (MutableLiveData<List<Event>>)eventRepository.getAllEvents(codes);
         }
         return eventsLiveData;

     }

    public static class Factory implements ViewModelProvider.Factory {
        private final Context ctxt;

        Factory(Context ctxt) {
            this.ctxt=ctxt.getApplicationContext();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return((T)new EventViewModel(ctxt));
        }
    }
}
