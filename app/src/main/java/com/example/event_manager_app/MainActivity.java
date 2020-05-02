

package com.example.event_manager_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences sp1;
    SharedPreferences useremail;

    private ImageView coordinator;
    private ImageView volunteer;
    private ImageView participant;
    private TextView logout ;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinator =  findViewById(R.id.coord);
        volunteer = findViewById(R.id.volunteer);
        participant =  findViewById(R.id.parti);
        logout = findViewById(R.id.logout) ;
        sp1 = getSharedPreferences("Main Activity",MODE_PRIVATE);
        sp= getSharedPreferences("login",MODE_PRIVATE);
        useremail = getSharedPreferences("useremail",MODE_PRIVATE);


        //final String currentUserEmail = getIntent().getStringExtra("email");
        final String currentUserEmail = useremail.getString("user-email",null);

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
                goToParticipantOptionsActivity(currentUserEmail);
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
                sp.edit().putBoolean("logged",false).apply();
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
    public void goToParticipantOptionsActivity(String currentUserEmail){
        Intent i = new Intent(this, PartcipantOptionActivity.class);
        i.putExtra("poemail",currentUserEmail);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }



}