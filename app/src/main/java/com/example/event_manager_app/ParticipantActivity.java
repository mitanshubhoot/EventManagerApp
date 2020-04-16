package com.example.event_manager_app;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParticipantActivity extends AppCompatActivity {
    private ParticipantViewModel pmodel;
    private EventViewModel emodel ;
    private RecyclerView recyclerView;
    private List<String> codes;
    private MediatorLiveData<List<Event>> mediatorLiveData = new MediatorLiveData<>();
    private ParticipantActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participant);
        final String currentUserEmail = getIntent().getStringExtra("pemail");
        pmodel = ViewModelProviders.of(this, new ParticipantViewModel.Factory(getApplicationContext())).get(ParticipantViewModel.class);
        //emodel = ViewModelProviders.of(this, new EventViewModel.Factory(getApplicationContext())).get(EventViewModel.class);
        emodel = ViewModelProviders.of(this ).get( EventViewModel.class);
        recyclerView = (RecyclerView) findViewById(R.id.list_events);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);
         codes = pmodel.getEventCodes(currentUserEmail);

        final EventAdaptor adaptor = new EventAdaptor();
        recyclerView.setAdapter(adaptor);

        Log.d("partcipant activity", "hii"+ emodel.getAllEvents(codes).getValue());
        List<Event> initial = emodel.getInitialStatus();
        Log.d("partcipant activity", "initial status "+(initial.size()));
        Log.d("codes","codes are "+codes);

        emodel.getAllEvents(codes).observe(this, new Observer<List<Event>>() {
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
    }

    }

