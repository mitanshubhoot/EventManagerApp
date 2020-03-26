package com.example.event_manager_app;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CoordinatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);
        final String currentUserEmail = getIntent().getStringExtra("cemail");

        Toast.makeText(getBaseContext(), "onchanged" +
                " " , Toast.LENGTH_LONG).show();
    }
}
