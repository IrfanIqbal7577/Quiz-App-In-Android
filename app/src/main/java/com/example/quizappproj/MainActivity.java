package com.example.quizappproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnstart,btnabout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initwidget();
        callListener();
    }

    private void initwidget() {
         btnstart = findViewById(R.id.btnstart);
         btnabout = findViewById(R.id.btnabout);

    }


    private void callListener() {
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this, categories.class);
                startActivity(intent);

            }
        });

        btnabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Developers.class);
                startActivity(intent);

            }
        });


    }
}


