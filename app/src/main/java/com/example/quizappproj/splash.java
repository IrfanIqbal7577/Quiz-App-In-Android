package com.example.quizappproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        image=(ImageView)findViewById(R.id.imag);
       image.animate().scaleX(-0.7f).scaleY(0.7f).setDuration(3000);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i =new Intent(splash.this,Registration.class);
                startActivity(i);
                finish();
            }
        },3000);

    }
}