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
    private EditText mEmail, mPassword;
    private TextView mlogin;
    private ProgressBar mProgressBar;
    private RelativeLayout register;
    private LoginViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        register = (RelativeLayout) findViewById(R.id.register);
        mlogin = (TextView) findViewById(R.id.login);
        mEmail = (EditText) findViewById(R.id.username_r) ;
        mPassword = (EditText) findViewById(R.id.password_r) ;
        mProgressBar = (ProgressBar) findViewById(R.id.loading) ;


        userViewModel = ViewModelProviders.of(this, new LoginViewModel.Factory(getApplicationContext())).get(LoginViewModel.class);
        final String email = mEmail.getText().toString();
        if(sp.getBoolean("logged",false)){
            goToMainActivity(email);
            finish();
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
