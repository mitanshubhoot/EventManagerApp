package com.example.event_manager_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExploreEventsActivity extends AppCompatActivity {
    private TextView name ;
    private TextView email ;
    private TextView winner_prize;
    private TextView runner_prize;
    private TextView description;
    private TextView event_date;
    private TextView entry_fees;

    public static final String Ex_EMAIL = "email";
    public static final String Ex_NAME = "name";
    public static final String Ex_WINNER_PRIZE = "winner prize";
    public static final String Ex_RUNNER_PRIZE = "runner prize";
    public static final String Ex_DATE= "date";
    public static final String Ex_Description = "description";
    public static final String Ex_ENTRY_FEES = "entry fees";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_events);

        name = findViewById(R.id.event_name_ex);
        email = findViewById(R.id.coord_email_ex);
        winner_prize = findViewById(R.id.winner_prize_ex);
        runner_prize = findViewById(R.id.runner_up_prize_ex);
        description = findViewById(R.id.Description_ex);
        entry_fees = findViewById(R.id.entry_fees_ex);
        event_date = findViewById(R.id.event_date_ex);

        Intent intent = new Intent();
        name.setText(String.valueOf(getIntent().getStringExtra(Ex_NAME)));
        email.setText(intent.getStringExtra(Ex_EMAIL));

    }

    @Override
    public void onStart() {


        super.onStart();
        Intent intent = new Intent();


        String mname = getIntent().getStringExtra(Ex_NAME);
        if(mname==null)
        {
            mname = String.valueOf(getIntent().getStringExtra(Ex_NAME));
        }
        name.setText(mname);

        String memail = getIntent().getStringExtra(Ex_EMAIL);
        if(memail==null)
        {
            memail = String.valueOf(getIntent().getStringExtra(Ex_EMAIL));
        }
        email.setText(memail);
        String mdate = getIntent().getStringExtra(Ex_DATE);
        if(mdate==null)
        {
            mdate = String.valueOf(getIntent().getStringExtra(Ex_DATE));
        }
        event_date.setText(mdate);

        String mdescription = getIntent().getStringExtra(Ex_Description);
        if(mdescription==null)
        {
            mdescription = String.valueOf(getIntent().getStringExtra(Ex_Description));
        }
        description.setMovementMethod(new ScrollingMovementMethod());
        description.setText(mdescription);

        long mentry_fees = getIntent().getLongExtra(Ex_ENTRY_FEES,-1);
        if(mentry_fees < 0)
        {
            mentry_fees = Long.parseLong(getIntent().getStringExtra(Ex_ENTRY_FEES));
        }
        entry_fees.setText(String.valueOf(mentry_fees));


        long mwinnerprize = getIntent().getLongExtra(Ex_WINNER_PRIZE,-1);
        if (mwinnerprize < 0){
            mwinnerprize = Long.parseLong(getIntent().getStringExtra(Ex_WINNER_PRIZE));
        }
        winner_prize.setText(String.valueOf(mwinnerprize));


        long mrunnerprize = getIntent().getLongExtra(Ex_RUNNER_PRIZE,-1);
        if (mrunnerprize < 0){
            mrunnerprize = Long.parseLong(getIntent().getStringExtra(Ex_RUNNER_PRIZE));
        }
        runner_prize.setText(String.valueOf(mrunnerprize));




        Log.d("Event got 2" , "h"+String.valueOf(intent.getStringExtra(Ex_NAME)) );




    }

}
