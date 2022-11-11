package com.example.quizappproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText etusername,etemail,etpassword;
    Button btnRegister;
    private String userEmail,userpassword,username;
    private SharedPreferences sharedPreferences;
    public static final String preference_name="register data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etusername=findViewById(R.id.etusername);
        etemail=findViewById(R.id.etemail);
        etpassword=findViewById(R.id.etpassword);
        btnRegister=findViewById(R.id.btnRegister);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkDataEntered())
                {
                    if(isEmailValid(userEmail))
                    {
                        sharedPreferences = getSharedPreferences(preference_name, 0);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("email",userEmail);
                        editor.putString("password",userpassword);
                        editor.putString("username",username);
                        editor.apply();
                        Intent intent=new Intent(Registration.this,Login.class);
                        startActivity(intent);

                }
                    else
                    {

                    }
            }}
        });
    }



    private boolean checkDataEntered(){

            getValues();


        if(TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(userpassword) || TextUtils.isEmpty(username))
        {
            return false;
        }
        else
        {
            return true;
        }
    }




    private void getValues() {
        username=etusername.getText().toString();
      userEmail=etemail.getText().toString();
         userpassword=etpassword.getText().toString();

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
}