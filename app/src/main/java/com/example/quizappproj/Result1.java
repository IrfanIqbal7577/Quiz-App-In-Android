package com.example.quizappproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result1 extends AppCompatActivity {

    TextView tva, tv2a, tv3a;
    Button btnRestart1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);


        tva = (TextView)findViewById(R.id.tvres1);
        tv2a = (TextView)findViewById(R.id.tvres2a);
        tv3a = (TextView)findViewById(R.id.tvres3a);
        btnRestart1 = (Button) findViewById(R.id.btnRestart1);


        tva.setText("Correct answers: " + General_knw.correct1 + "\n");
        tv2a.setText("Wrong Answers: " + General_knw.wrong1 + "\n");
        tv3a.setText("Final Score: " + General_knw.correct1 + "\n");

        General_knw.correct1=0;
        General_knw.wrong1=0;

        btnRestart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Result1.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}