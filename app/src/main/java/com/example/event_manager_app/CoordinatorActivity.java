package com.example.event_manager_app;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoordinatorActivity extends AppCompatActivity {
    private VolunteerViewModel volunteerViewModel;
    private RecyclerView recyclerView;
    private List<Volunteer> volunteers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        final String currentUserEmail = getIntent().getStringExtra("cemail");

        volunteerViewModel = ViewModelProviders.of(this, new VolunteerViewModel.Factory(getApplicationContext())).get(VolunteerViewModel.class);

        recyclerView = (RecyclerView) findViewById(R.id.list_volunteers);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);
        volunteers = volunteerViewModel.getAllVolunteers(currentUserEmail);

        final VolunteerAdaptor adaptor = new VolunteerAdaptor();
        recyclerView.setAdapter(adaptor);
        adaptor.setVolunteers(volunteers);






        Log.d("Volunteers" , "hii"+ volunteers.size());


    }

}
