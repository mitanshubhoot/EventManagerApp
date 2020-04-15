package com.example.event_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private TextView save;
    public static final String V_EMAIL = "Email";
    public static final String V_NAME = "name";
    public static final String V_HOURS_PUBLICITY = "publicity";
    public static final String V_CONTACT = "contact";
    public static final String V_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_details);
        name = findViewById(R.id.Volunteer_Name);
        email = findViewById(R.id.email_volunteer);
        contact = findViewById(R.id.contact_volunteer);
        publicity_hours = findViewById(R.id.publicity_hours_v);
        save = findViewById(R.id.Save);
        add = findViewById(R.id.add_vol);
        sub = findViewById(R.id.sub_vol);

        Intent intent = new Intent();
        name.setText(intent.getStringExtra(V_NAME));
        email.setText(intent.getStringExtra(V_EMAIL));
        contact.setText(String.valueOf(intent.getIntExtra(V_CONTACT,-1)) );
        publicity_hours.setText(String.valueOf( intent.getIntExtra(V_HOURS_PUBLICITY, 0)));
        int id = intent.getIntExtra(V_ID,-1);

        Log.d("volunteer got" , "h"+intent.getStringExtra(V_NAME) + "id" + id );



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                publicity_hours.setText( String.valueOf(Integer.valueOf(publicity_hours.getText().toString())+1) );



            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                publicity_hours.setText( String.valueOf(Integer.valueOf(publicity_hours.getText().toString())-1) );


            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveInfoVolunteer();
            }
        });


    }
    @Override
    public void onStart() {


        super.onStart();
        Intent intent = new Intent();
        name.setText(intent.getStringExtra(V_NAME));
        email.setText(intent.getStringExtra(V_EMAIL));
        contact.setText(String.valueOf(intent.getIntExtra(V_CONTACT,-1)) );
        publicity_hours.setText(String.valueOf( intent.getIntExtra(V_HOURS_PUBLICITY, 0)));
        Log.d("volunteer got 2" , "h"+intent.getStringExtra(V_NAME) );


    }


    public  void SaveInfoVolunteer()
    {

        int mPublicity = Integer.valueOf(publicity_hours.getText().toString());
        int mid = Integer.valueOf(publicity_hours.getText().toString());
        Intent data = new Intent();
        data.putExtra(V_HOURS_PUBLICITY , mPublicity);
        data.putExtra(V_ID , mid);
        setResult(RESULT_OK, data);

        finish();
    }
}
