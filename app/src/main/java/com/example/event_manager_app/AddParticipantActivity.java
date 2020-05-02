package com.example.event_manager_app;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class AddParticipantActivity extends AppCompatActivity {
    private EditText name ;
    private EditText event_code ;
    private EditText college ;
    private EditText year ;
    private EditText email;
    private EditText contact ;
    private RelativeLayout Add;
    private ParticipantViewModel pmodel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_participant);
        name = (EditText)findViewById(R.id.parti_name_ap);
        event_code = (EditText)findViewById(R.id.event_code_ap);
        college = (EditText)findViewById(R.id.college_ap);
        year = (EditText)findViewById(R.id.year_ap);
        email = (EditText)findViewById(R.id.email_ap);
        contact = (EditText)findViewById(R.id.contact_ap);
        Add = (RelativeLayout) findViewById(R.id.add_p);
        pmodel = ViewModelProviders.of(this , new ParticipantViewModel.Factory(getApplicationContext())).get(ParticipantViewModel.class);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mname = name.getText().toString();
                Pattern p = Pattern.compile("[a-zA-Z]*");//to check special characters
                Matcher m = p.matcher(mname);

                if(!email.getText().toString().equals("") && !event_code.getText().toString().equals("") && m.matches()) {
                    pmodel.addParticipant(name.getText().toString(), event_code.getText().toString(),college.getText().toString(),year.getText().toString() , email.getText().toString(), Long.parseLong(contact.getText().toString()));
                    Toast.makeText(getBaseContext(), "participant added ", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
