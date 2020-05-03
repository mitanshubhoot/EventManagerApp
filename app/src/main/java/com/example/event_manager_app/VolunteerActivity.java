package com.example.event_manager_app;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class VolunteerActivity extends AppCompatActivity {
    private Button attendance;
    private Button add;
    private TextView no_participants;
    private TextView no_attended_participants;
    private ParticipantViewModel pmodel;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);
        attendance = findViewById(R.id.attendance);
        add = findViewById(R.id.Add_parti);
        no_participants = (TextView)findViewById(R.id.no_of_participants);
        no_attended_participants= (TextView)findViewById(R.id.attendees_count);

        mProgressBar = (ProgressBar)findViewById(R.id.loading_v);
        final String currentUserEmail = getIntent().getStringExtra("cemail");


        pmodel = ViewModelProviders.of(this , new ParticipantViewModel.Factory(getApplicationContext())).get(ParticipantViewModel.class);
        mProgressBar.setVisibility(View.VISIBLE);
        Log.i("Progress bar ", "visible");

        int count = pmodel.GetCountParticipant();
        no_participants.setText(Integer.toString(count));

        int count_attendees = pmodel.GetCountAttendanceParticipant();
        no_attended_participants.setText(Integer.toString(count_attendees));

        Log.i("count ", "updated");
        mProgressBar.setVisibility(View.INVISIBLE);
        Log.i("Progress bar ", "invisible");

        Toast.makeText(getBaseContext(), "participant added " + count, Toast.LENGTH_LONG).show();


        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VolunteerActivity.this , AttendanceActivity.class);
                startActivity(i);

            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoAddParticipantActivity();
            }
        });
    }
    public void gotoAddParticipantActivity(){
        Intent i = new Intent(this,AddParticipantActivity.class);
        startActivity(i);
    }


    @Override
    public void onResume() {
        super.onResume();
        int count = pmodel.GetCountParticipant();
        no_participants.setText(Integer.toString(count));

        int count_attendees = pmodel.GetCountAttendanceParticipant();
        no_attended_participants.setText(Integer.toString(count_attendees));
    }
}
