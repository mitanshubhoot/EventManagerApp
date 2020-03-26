package com.example.event_manager_app;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParticipantActivity extends AppCompatActivity {
    private ParticipantViewModel pmodel;
    private EventViewModel emodel ;
    private RecyclerView recyclerView;

    private ParticipantActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant);
        //final String currentUserEmail = getIntent().getStringExtra("pemail");
        final String currentUserEmail = "oswalsakshi17@gmail.com";
        pmodel = ViewModelProviders.of(this, new ParticipantViewModel.Factory(getApplicationContext())).get(ParticipantViewModel.class);
        //emodel = ViewModelProviders.of(this, new EventViewModel.Factory(getApplicationContext())).get(EventViewModel.class);
        emodel = ViewModelProviders.of(this ).get( EventViewModel.class);
        recyclerView = (RecyclerView) findViewById(R.id.list_events);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);
        List<String> codes = pmodel.getEventCodes(currentUserEmail);
        LiveData<List<Event>> events = emodel.getAllEvents(codes);
        final EventAdaptor adaptor = new EventAdaptor();
        recyclerView.setAdapter(adaptor);
        Log.d("partcipant activity", "hii"+ emodel.getAllEvents(codes).getValue());
        List<Event> initial = emodel.getInitialStatus();
        Log.d("partcipant activity", "initial status "+initial.get(0).getEvent_code() );




        Log.d("partcipant activity", "hii"+ codes );
        Log.d("partcipant email", " hh"+ (pmodel.getParticipants().get(0).getYear()) +"curent user " +currentUserEmail  + pmodel.getParticipants().get(0).getEvent_code());


        events.observe(this, new Observer<List<Event>>() {
                    @Override
                    public void onChanged(List<Event> events) {
                        //update recycler view
                        adaptor.setEvents(events);
                        //Toast.makeText(ParticipantActivity.this , "Onchanged",Toast.LENGTH_SHORT).show();
                        Toast.makeText(getBaseContext(), "observer" +
                                " " , Toast.LENGTH_LONG).show();
                        Log.d("partcipant activity", "hii");

                    }
                });


                //adaptor = new EventAdaptor(events);

        /*emodel.getAllEvents(codes);
        adaptor = new MyAdaptor(context,(List<Event>) events);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adaptor);
    //.observe(context , userListUpdateObserver);
       */
    }


    /*
    Observer<List<Event>> userListUpdateObserver = new Observer<List<Event>>() {
        @Override
        public void onChanged(List<Event> events) {
            adaptor = new MyAdaptor(context,events);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(adaptor);
        }
    }; */

    }

