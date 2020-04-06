package com.example.event_manager_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VolunteerDetailsActivity extends AppCompatActivity {
    private TextView name ;
    private TextView email ;
    private TextView contact;
    private TextView publicity_hours;
    private Button add;
    private Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_details);
        name = findViewById(R.id.Volunteer_Name);
        email = findViewById(R.id.email_volunteer);
        contact = findViewById(R.id.contact_volunteer);
        publicity_hours = findViewById(R.id.publicity_hours_v);
        add = findViewById(R.id.add_vol);
        sub = findViewById(R.id.sub_vol);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
