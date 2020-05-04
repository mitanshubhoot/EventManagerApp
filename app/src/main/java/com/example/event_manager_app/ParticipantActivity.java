package com.example.event_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParticipantActivity extends AppCompatActivity {
    private ParticipantViewModel pmodel;
    private EventViewModel emodel ;
    private RecyclerView recyclerView;
    private List<String> codes;
    private List<Event> events;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant);
        final String currentUserEmail = getIntent().getStringExtra("pemail");
        pmodel = ViewModelProviders.of(this, new ParticipantViewModel.Factory(getApplicationContext())).get(ParticipantViewModel.class);
        emodel = ViewModelProviders.of(this ).get( EventViewModel.class);
        recyclerView = (RecyclerView) findViewById(R.id.list_events);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);
         codes = pmodel.getEventCodes(currentUserEmail);

        final EventAdaptor adaptor = new EventAdaptor();
        recyclerView.setAdapter(adaptor);

        events = emodel.getEvents(codes);
        adaptor.setEvents(events);
        Log.d("Event_ list" ," "+ events.size());

        adaptor.setOnItemEventClickListener(new EventAdaptor.onItemEventClickListener() {
            @Override
            public void onItemEventClick(Event event) {
                Intent i = new Intent(ParticipantActivity.this , EventDetailsActivity.class);
                i.putExtra(EventDetailsActivity.E_NAME, event.getEvent_name());
                i.putExtra(EventDetailsActivity.E_CODE, event.getEvent_code());
                i.putExtra(EventDetailsActivity.E_DATE , event.getDate());
                i.putExtra(EventDetailsActivity.E_RUNNER_PRIZE, event.getRunner_prize());
                i.putExtra(EventDetailsActivity.E_WINNER_PRIZE, event.getWinner_prize());
                i.putExtra(EventDetailsActivity.E_VENUE, event.getVenue());
                i.putExtra(EventDetailsActivity.E_EMAIL, event.getEmail_coord());
                Log.d("Event" , "h"+ event.getEvent_name());

                startActivity(i);
            }
        });


    }

    }

