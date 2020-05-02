package com.example.event_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class ExploreActivty extends AppCompatActivity {
    private ParticipantViewModel pmodel;
    private EventViewModel emodel ;
    private RecyclerView recyclerView;
    private List<String> codes;
    private List<Event> events;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String currentUserEmail = getIntent().getStringExtra("explore_email");
        setContentView(R.layout.activity_explore_activty);

        pmodel = ViewModelProviders.of(this, new ParticipantViewModel.Factory(getApplicationContext())).get(ParticipantViewModel.class);

        emodel = ViewModelProviders.of(this ).get( EventViewModel.class);

        recyclerView = (RecyclerView) findViewById(R.id.list_explore_events);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d("email" , "h"+ currentUserEmail);



        recyclerView.setHasFixedSize(true);
        codes = pmodel.getEventCodes(currentUserEmail);
        Log.d("codes" , "h"+ codes.size() +"  "+ codes);


        final EventAdaptor adaptor = new EventAdaptor();
        recyclerView.setAdapter(adaptor);

        events = emodel.getExploreEvents(codes);
        adaptor.setEvents(events);



        adaptor.setOnItemEventClickListener(new EventAdaptor.onItemEventClickListener() {
            @Override
            public void onItemEventClick(Event event) {
                Intent i = new Intent(ExploreActivty.this , ExploreEventsActivity.class);
                i.putExtra(ExploreEventsActivity.Ex_NAME, event.getEvent_name());
                i.putExtra(ExploreEventsActivity.Ex_ENTRY_FEES, event.getEntry_fee());
                i.putExtra(ExploreEventsActivity.Ex_DATE , event.getDate());
                i.putExtra(ExploreEventsActivity.Ex_WINNER_PRIZE, event.getWinner_prize());
                i.putExtra(ExploreEventsActivity.Ex_RUNNER_PRIZE, event.getRunner_prize());
                i.putExtra(ExploreEventsActivity.Ex_Description, event.getDescription());
                i.putExtra(ExploreEventsActivity.Ex_EMAIL, event.getEmail_coord());
                Log.d("Event" , "h"+ event.getEvent_name());

                startActivity(i);
            }
        });

    }
}
