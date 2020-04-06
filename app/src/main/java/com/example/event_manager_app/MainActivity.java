

package com.example.event_manager_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences sp1;
    private Button coordinator;
    private Button volunteer;
    private Button participant;
    private RelativeLayout logout ;
    private static final String TAG = "MainActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinator = (Button) findViewById(R.id.cord1);
        volunteer = (Button) findViewById(R.id.volu1);
        participant = (Button) findViewById(R.id.parti1);
        logout = (RelativeLayout) findViewById(R.id.logout) ;
        sp1 = getSharedPreferences("Main Activity",MODE_PRIVATE);
        sp= getSharedPreferences("login",MODE_PRIVATE);

        final String currentUserEmail = getIntent().getStringExtra("email");

        Log.i("email" , "my email = " + currentUserEmail );



        coordinator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCoordinatorActivity(currentUserEmail);
            }
        });
        volunteer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToVolunteerActivity(currentUserEmail);
            }
        });
        participant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToParticipantActivity(currentUserEmail);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "BYE BYE!", Toast.LENGTH_LONG).show();
                sp.edit().putBoolean("logged",false).apply();
                Log.d(TAG, "signOut: User signed out");
                goToLoginActivity();
                Log.d(TAG, "go to login");
            }
        });

    }
    public void onStart() {

        super.onStart();
        final String currentUserEmail = getIntent().getStringExtra("email");
        Log.i("email" , currentUserEmail + "em");

    }

    public void goToCoordinatorActivity( String currentUserEmail){
        Intent i = new Intent(this,CoordinatorActivity.class);
        i.putExtra("cemail",currentUserEmail);
        startActivity(i);
    }
    public void goToLoginActivity(){
        Intent i = new Intent(this,LoginActivity.class);
        sp1.edit().putBoolean("logout",true).apply();
        i.putExtra("login",true);
        startActivity(i);
    }
    public void goToVolunteerActivity(String currentUserEmail){
        Intent i = new Intent(this,VolunteerActivity.class);
        i.putExtra("cemail",currentUserEmail);
        startActivity(i);
    }
    public void goToParticipantActivity(String currentUserEmail){
        Intent i = new Intent(this,ParticipantActivity.class);
        i.putExtra("pemail",currentUserEmail);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}