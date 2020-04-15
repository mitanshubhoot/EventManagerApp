package com.example.event_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoordinatorActivity extends AppCompatActivity {
    private VolunteerViewModel volunteerViewModel;
    private RecyclerView recyclerView;

    public static final int UPDATE_VOLUNTEER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        final String currentUserEmail = getIntent().getStringExtra("cemail");

        volunteerViewModel = ViewModelProviders.of(this, new VolunteerViewModel.Factory(getApplicationContext())).get(VolunteerViewModel.class);

        recyclerView = (RecyclerView) findViewById(R.id.list_volunteers);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);


        final VolunteerAdaptor adaptor = new VolunteerAdaptor();
        recyclerView.setAdapter(adaptor);

        adaptor.setOnItemClickListener(new VolunteerAdaptor.onItemClickListener() {
            @Override
            public void onItemClick(Volunteer volunteer) {
                Intent i = new Intent(CoordinatorActivity.this , VolunteerDetailsActivity.class);
                i.putExtra(VolunteerDetailsActivity.V_NAME, volunteer.getName());
                i.putExtra(VolunteerDetailsActivity.V_EMAIL , volunteer.getEmail());
                i.putExtra(VolunteerDetailsActivity.V_HOURS_PUBLICITY , volunteer.getNoOfHoursPublicity());
                i.putExtra(VolunteerDetailsActivity.V_CONTACT , volunteer.getNumber());
                i.putExtra(VolunteerDetailsActivity.V_ID , volunteer.getVid());
                Log.d("Volunteers" , "h"+ volunteer.getName());

                startActivityForResult(i , UPDATE_VOLUNTEER_REQUEST);

            }
        });

        volunteerViewModel.getAllVolunteers(currentUserEmail).observe(this, new Observer<List<Volunteer>>() {
            @Override
            public void onChanged(List<Volunteer> volunteers) {
                adaptor.setVolunteers(volunteers);
  }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== UPDATE_VOLUNTEER_REQUEST && resultCode==RESULT_OK)
        {
            int publicity_hours = data.getIntExtra(VolunteerDetailsActivity.V_HOURS_PUBLICITY,0);
            int vid = data.getIntExtra(VolunteerDetailsActivity.V_ID,-1);
            if(vid != -1)
            {
                volunteerViewModel.update_hours(vid , publicity_hours);
                Toast.makeText(this, "update saved with id : " + vid , Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "id not found", Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(this, "Nothing updated"+requestCode+" " + RESULT_OK+ "=" + resultCode, Toast.LENGTH_SHORT).show();
    }
}
