package com.example.event_manager_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttendanceActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ParticipantViewModel participantViewModel;
    private List<Participant> participantList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        recyclerView = findViewById(R.id.list_volunteers_attendance);
        participantViewModel = ViewModelProviders.of(this, new ParticipantViewModel.Factory(getApplicationContext())).get(ParticipantViewModel.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setHasFixedSize(true);
        participantList = participantViewModel.getParticipants();

        final AttendanceAdaptor adaptor = new AttendanceAdaptor();
        recyclerView.setAdapter(adaptor);
       adaptor.setPartcipants(participantList);


    }
    @Override
    public void onStart() {

        super.onStart();

    }
}
