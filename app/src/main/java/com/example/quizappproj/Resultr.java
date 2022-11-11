package com.example.quizappproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultr extends AppCompatActivity {

    TextView tvr, tv2r, tv3r;
    Button btnRestartr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultr);


        tvr = (TextView)findViewById(R.id.tvresr);
        tv2r = (TextView)findViewById(R.id.tvres2r);
        tv3r = (TextView)findViewById(R.id.tvres3r);
        btnRestartr = (Button) findViewById(R.id.btnRestartr);


        tvr.setText("Correct answers: " + Riddle.correctr + "\n");
        tv2r.setText("Wrong Answers: " + Riddle.wrongr + "\n");
        tv3r.setText("Final Score: " + Riddle.correctr + "\n");

        Riddle.correctr=0;
        Riddle.wrongr=0;

        btnRestartr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Resultr.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}