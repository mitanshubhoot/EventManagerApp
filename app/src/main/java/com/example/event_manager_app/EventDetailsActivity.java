package com.example.event_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EventDetailsActivity extends AppCompatActivity {
    private TextView name ;
    private TextView email ;
    private TextView winner_prize;
    private TextView runner_prize;
    private TextView event_code;
    private TextView event_date;
    private TextView venue;


    public static final String E_EMAIL = "email";
    public static final String E_NAME = "name";
    public static final String E_WINNER_PRIZE = "winner prize";
    public static final String E_RUNNER_PRIZE = "runner prize";
    public static final String E_DATE= "date";
    public static final String E_VENUE = "venue";
    public static final String E_CODE = "event_code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        name = findViewById(R.id.event_name_e);
        email = findViewById(R.id.coord_email);
        winner_prize = findViewById(R.id.winner_prize);
        runner_prize = findViewById(R.id.runner_up_prize);
        venue = findViewById(R.id.venue);
        event_code = findViewById(R.id.event_code_e);
        event_date = findViewById(R.id.event_date_e);

        Intent intent = new Intent();
        name.setText(String.valueOf(getIntent().getStringExtra(E_NAME)));
        email.setText(intent.getStringExtra(E_EMAIL));

    }

    @Override
    public void onStart() {


        super.onStart();
        Intent intent = new Intent();


        String mname = getIntent().getStringExtra(E_NAME);
        if(mname==null)
        {
            mname = String.valueOf(getIntent().getStringExtra(E_NAME));
        }
        name.setText(mname);

        String memail = getIntent().getStringExtra(E_EMAIL);
        if(memail==null)
        {
            memail = String.valueOf(getIntent().getStringExtra(E_EMAIL));
        }
        email.setText(memail);
        String mdate = getIntent().getStringExtra(E_DATE);
        if(mdate==null)
        {
            mdate = String.valueOf(getIntent().getStringExtra(E_DATE));
        }
        event_date.setText(mdate);

        String mvenue = getIntent().getStringExtra(E_VENUE);
        if(mvenue==null)
        {
           mvenue = String.valueOf(getIntent().getStringExtra(E_VENUE));
        }
        venue.setText(mvenue);

        String mcode = getIntent().getStringExtra(E_CODE);
        if(mcode==null)
        {
            mcode = String.valueOf(getIntent().getStringExtra(E_CODE));
        }
        event_code.setText(mcode);


        long mwinnerprize = getIntent().getLongExtra(E_WINNER_PRIZE,-1);
        if (mwinnerprize < 0){
            mwinnerprize = Long.parseLong(getIntent().getStringExtra(E_WINNER_PRIZE));
        }
        winner_prize.setText(String.valueOf(mwinnerprize));


        long mrunnerprize = getIntent().getLongExtra(E_RUNNER_PRIZE,-1);
        if (mrunnerprize < 0){
            mrunnerprize = Long.parseLong(getIntent().getStringExtra(E_RUNNER_PRIZE));
        }
        runner_prize.setText(String.valueOf(mrunnerprize));




        Log.d("Event got 2" , "h"+String.valueOf(intent.getStringExtra(E_NAME)) );




    }

}
