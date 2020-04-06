package com.example.event_manager_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class RegisterActivity extends AppCompatActivity {

    SharedPreferences sp;
    SharedPreferences sp1;
    private EditText mEmail, mPassword;
    private TextView mlogin;
    private ProgressBar mProgressBar;
    private RelativeLayout register;
    private LoginViewModel userViewModel;
    public static String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        sp1 = getSharedPreferences("Main Activty",MODE_PRIVATE);

        register = (RelativeLayout) findViewById(R.id.register);
        mlogin = (TextView) findViewById(R.id.login);
        mEmail = (EditText) findViewById(R.id.username_r) ;
        mPassword = (EditText) findViewById(R.id.password_r) ;
        mProgressBar = (ProgressBar) findViewById(R.id.loading) ;


        userViewModel = ViewModelProviders.of(this, new LoginViewModel.Factory(getApplicationContext())).get(LoginViewModel.class);
        if(sp.getBoolean("logged",false)  ){
            goToMainActivity(mEmail.getText().toString());
            finish();
        }
        if(sp1.getBoolean("logout",false))
        {
            goToLoginActivity();
        }
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginActivity();

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=mEmail.getText().toString();
                boolean isValid = userViewModel.checkValidRegister(email);
                if(isValid) {
                    mProgressBar.setVisibility(View.VISIBLE);
                    userViewModel.createUser(email, mPassword.getText().toString());
                    Toast.makeText(getBaseContext(), "Successfully Created An Account!", Toast.LENGTH_LONG).show();
                    goToMainActivity(email);
                    sp.edit().putBoolean("logged",true).apply();
                    finish();
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Account not created !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void goToLoginActivity(){
        Intent i = new Intent(this,LoginActivity.class );
        startActivity(i);
    }
    public void goToMainActivity( String email){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("email", email);
        startActivity(i);
    }
}
