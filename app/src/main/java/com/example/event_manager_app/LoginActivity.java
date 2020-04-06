package com.example.event_manager_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class LoginActivity extends AppCompatActivity {


    SharedPreferences sp;
    private EditText mEmail, mPassword;
    private TextView mRegisterTextView;
    private ProgressBar mProgressBar;
    private RelativeLayout mLoginButton;
    private LoginViewModel userViewModel;
    public static String  email ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginButton= (RelativeLayout) findViewById(R.id.login_rl);
        mRegisterTextView = (TextView) findViewById(R.id.register_tv);
        mEmail = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mProgressBar = (ProgressBar) findViewById(R.id.loading) ;

        sp = getSharedPreferences("login",MODE_PRIVATE);

        userViewModel = ViewModelProviders.of(this, new LoginViewModel.Factory(getApplicationContext())).get(LoginViewModel.class);

        if(sp.getBoolean("logged",false)){
            goToMainActivity(email);
            finish();
        }

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEmail.getText().toString();
                boolean isValid = userViewModel.checkValidLogin(mEmail.getText().toString(), mPassword.getText().toString());
                if(mEmail.getText().toString().equals(""))
                {
                    Toast.makeText(getBaseContext(), "please enter email", Toast.LENGTH_LONG).show();
                    Log.i("email", "empty");


                }
                if(isValid )
                {
                    mProgressBar.setVisibility(View.VISIBLE);
                    Toast.makeText(getBaseContext(), "Successfully Logged In!", Toast.LENGTH_LONG).show();
                    goToMainActivity(mEmail.getText().toString());
                    sp.edit().putBoolean("logged",true).apply();
                    finish();
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Invalid Login!", Toast.LENGTH_SHORT).show();
                    Log.i("Unsuccessful_Login", "Login was not successful");
                }


            }
        });
        mRegisterTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegisterActivity();
                sp.edit().putBoolean("logged",true).apply();
            }
        });

    }


    public void goToMainActivity(String email){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("email",email);
        startActivity(i);
    }
    public void goToRegisterActivity(){
        Intent i = new Intent(this,RegisterActivity.class);
        startActivity(i);
    }

}
