package com.example.event_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PartcipantOptionActivity extends AppCompatActivity {
    private RelativeLayout eventlist;
    private RelativeLayout explore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partcipant_option);

        final String currentUserEmail = getIntent().getStringExtra("poemail");
        eventlist = findViewById(R.id.your_Events);
        explore = findViewById(R.id.Explore);

        eventlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToParticipantActivity(currentUserEmail);

            }
        });
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToExploreActivity(currentUserEmail);

            }
        });

    }
    public void goToParticipantActivity(String email){
        Intent i = new Intent(this,ParticipantActivity.class);
        i.putExtra("pemail",email);
        startActivity(i);
    }
    public void goToExploreActivity(String email){
        Intent i = new Intent(this,ExploreActivty.class);
        i.putExtra("explore_email",email);
        startActivity(i);
    }
}
