package com.example.quizappproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Riddle extends AppCompatActivity {

    TextView tvr;
    Button btnQr, btnquitr;
    RadioGroup answersgrpr;
    RadioButton radioBtn1r,radioBtn2r,radioBtn3r,radioBtn4r;


    String questionsr[] = {
            "What has to be broken before you can use it?",
            "What month of the year has 28 days?",
            "What question can you never answer yes to?",
            "What can you break, even if you never pick it up or touch it?",
            "What goes up but never comes down?",
            "What gets wet while drying?",
            "What can you keep after giving to someone?",
            "I have branches, but no fruit, trunk or leaves. What am I?",
            "What can’t talk but will reply when spoken to?",
            "The more of this there is, the less you see. What is it?"
    };
    String answersr[] = {"An egg","All of them","Are you asleep yet?","A promise","Your age","A towel","Your word","A bank","An echo","Darkness"};
    String optr[] = {
            "glass","An egg","silence","door",
            "January","Febuary","December","All of them",
            "Are you asleep yet?","Are you Hungry?","Are you happy?","Are you sad?",
            "Rock","Glass","A promise","All Of them",
            "Fever","Your age","Temperature","Voice",
            "Hands","Hairs","A towel","None of the above",
            "Your word","Gift","Money","Food",
            "Tree","A bank","Hairs","Brush",
            "Cellphone","An echo","Babies","Cat",
            "Water","Rain","Clouds","Darkness"
    };
    int flag=0;
    public static int marksr=0,correctr=0,wrongr=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);


        final TextView scorer = (TextView)findViewById(R.id.textView4r);



        btnQr=(Button)findViewById(R.id.btnQr);
        btnquitr=(Button)findViewById(R.id.btnquitr);
        tvr=(TextView) findViewById(R.id.tvquer);

        answersgrpr=(RadioGroup)findViewById(R.id.answersgrpr);
        radioBtn1r=(RadioButton)findViewById(R.id.radioBtn1r);
        radioBtn2r=(RadioButton)findViewById(R.id.radioBtn2r);
        radioBtn3r=(RadioButton)findViewById(R.id.radioBtn3r);
        radioBtn4r=(RadioButton)findViewById(R.id.radioBtn4r);

        tvr.setText(questionsr[flag]);
        radioBtn1r.setText(optr[0]);
        radioBtn2r.setText(optr[1]);
        radioBtn3r.setText(optr[2]);
        radioBtn4r.setText(optr[3]);

        btnQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(answersgrpr.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uansr = (RadioButton) findViewById(answersgrpr.getCheckedRadioButtonId());
                String ansTextr = uansr.getText().toString();

                if(ansTextr.equals(answersr[flag])) {
                    correctr++;
                    Toast.makeText(Riddle.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrongr++;
                    Toast.makeText(Riddle.this, "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (scorer != null)
                    scorer.setText(""+correctr);

                if(flag<questionsr.length)
                {
                    tvr.setText(questionsr[flag]);
                    radioBtn1r.setText(optr[flag*4]);
                    radioBtn2r.setText(optr[flag*4 +1]);
                    radioBtn3r.setText(optr[flag*4 +2]);
                    radioBtn4r.setText(optr[flag*4 +3]);
                }
                else
                {
                    marksr=correctr;
                    Intent in = new Intent(Riddle.this,Resultr.class);
                    startActivity(in);
                }
                answersgrpr.clearCheck();
            }
        });

        btnquitr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Riddle.this,Resultr.class);
                startActivity(intent);
            }
        });
    }
    }
