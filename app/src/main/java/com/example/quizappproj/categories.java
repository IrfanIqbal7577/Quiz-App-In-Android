package com.example.quizappproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class categories extends AppCompatActivity {

    Button btnGK,btnAndroid,btnRiddle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        btnGK=findViewById(R.id.btnGK);
        btnAndroid=findViewById(R.id.btnAndroid);
        btnRiddle=findViewById(R.id.btnRiddle);

        btnGK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent=new Intent(categories.this,General_knw.class);
               startActivity(intent);

            }
        });

        btnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(categories.this,Questions.class);
                startActivity(intent);

            }
        });

        btnRiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(categories.this,Riddle.class);
               startActivity(intent);

            }
        });
    }
}