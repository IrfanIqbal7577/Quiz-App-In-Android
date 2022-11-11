package com.example.quizappproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText lgnemail,lgnpassword;
    Button btnlogin,btnreg;
    private SharedPreferences sharedPreferences;
    public static final String preference_name="register data";
    private String userEmail,userpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();
        callListeners();

    }

    private void callListeners() {

        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAllFieldsFilled())
                {
                    if(isEmailValid(userEmail))
                    {
                        sharedPreferences= getSharedPreferences(preference_name,0);

                        String getEmail=sharedPreferences.getString("email","");
                        String getPassword=sharedPreferences.getString("password","");

                        if(isValueMatches(getEmail,getPassword))
                        {
                           Intent intent=new Intent(Login.this,MainActivity.class);
                           startActivity(intent);

                        }
                        else
                        {
                            Toast.makeText(Login.this , "Not Successful", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else
                    {


                    }
                }
                else
                {

                }

            }
        });

    }

    private boolean isValueMatches(String getEmail, String getPassword) {
        if(getEmail.equals(userEmail) & getPassword.equals(userpassword))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    private boolean isEmailValid(String userEmail) {
        if(Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    private boolean isAllFieldsFilled() {
        getInputValues();
        if(TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(userpassword) )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    private void getInputValues() {
        userEmail=lgnemail.getText().toString();
        userpassword=lgnpassword.getText().toString();

    }

    private void initialize() {
        lgnemail=findViewById(R.id.lgnemail);
       lgnpassword=findViewById(R.id.lgnpassword);
        btnlogin=findViewById(R.id.btnlogin);
        btnreg=findViewById(R.id.btnreg);

    }

}





