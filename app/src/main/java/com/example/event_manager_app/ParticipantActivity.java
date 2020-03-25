package com.example.event_manager_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParticipantActivity extends AppCompatActivity {
    private ParticipantViewModel pmodel;
    private EventViewModel emodel ;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adaptor;
    private ParticipantActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant);
        final String currentUserEmail = getIntent().getStringExtra("email");
        pmodel = ViewModelProviders.of(this, new ParticipantViewModel.Factory(getApplicationContext())).get(ParticipantViewModel.class);
        emodel = ViewModelProviders.of(this, new EventViewModel.Factory(getApplicationContext())).get(EventViewModel.class);
        recyclerView = (RecyclerView) findViewById(R.id.list_events);
        List<String> codes = pmodel.getEventCodes(currentUserEmail);
        LiveData<List<Event>> events = emodel.getAllEvents(codes);

        adaptor = new EventAdaptor(events);

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

