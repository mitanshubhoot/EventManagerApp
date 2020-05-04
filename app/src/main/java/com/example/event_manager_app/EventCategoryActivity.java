package com.example.event_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class EventCategoryActivity extends AppCompatActivity {
    private ImageView tech;
    private ImageView extra;
    private ImageView sports;
    private ImageView social;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_category);

        extra = findViewById(R.id.extra_cuu);
        sports = findViewById(R.id.sports);
        social = findViewById(R.id.socials);
        tech = findViewById(R.id.technical);
        final String currentUserEmail = getIntent().getStringExtra("explore_email");
        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToExploreActivity(currentUserEmail , "Technical");


            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToExploreActivity(currentUserEmail , "Sports");

            }
        });
        extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToExploreActivity(currentUserEmail , "Extra - Curricular");

            }
        });
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToExploreActivity(currentUserEmail , "Socials");

            }
        });

    }
    public void goToExploreActivity(String currentUserEmail , String domain){
        Intent i = new Intent(this, ExploreActivty.class);
        i.putExtra("domain",domain);
        i.putExtra("explore_email_2",currentUserEmail);

        startActivity(i);
    }
}
