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

public class General_knw extends AppCompatActivity {

    TextView tv1;
    Button btnQ1, btnquit1;
    RadioGroup answersgrp1;
    RadioButton radioBtn1,radioBtn2,radioBtn3,radioBtn4;


    String questions1[] = {
            "Entomology is the science that studies",
            "For which of the following disciplines is Nobel Prize awarded?",
            "Friction can be reduced by changing from",
            "Fire temple is the place of worship of which of the following religion?",
            "Filaria is caused by",
            "FRS stands for",
            "For safety, the fuse wire used in the mains for household supply of electricity must be made of metal having",
            "Durand Cup is associated with the game of",
            "Dr. Zakir Hussain was",
            "Fathometer is used to measure"
    };
    String answers1[] = {"Insects","All of the above","sliding to rolling","Zoroastrianism (Parsi Religion)","Mosquito","Fellow of Royal Society","low melting point","Football","the first Muslim president of India","Ocean depth"};
    String opt1[] = {
            "Behavior of human beings","Insects","The origin and history of technical and scientific terms","The formation of rocks",
            "Physics and Chemistry","Physiology or Medicine","Literature, Peace and Economics","All of the above",
            "sliding to rolling","rolling to sliding","potential energy to kinetic energy","dynamic to static",
            "Taoism","Judaism","Zoroastrianism (Parsi Religion)","Shintoism",
            "Bacteria","Mosquito","Protozoa","Virus",
            "Fellow Research System","Federation of Regulation Society","Fellow of Royal Society","None of the above",
            "low melting point","high resistance","high melting point","low specific heat",
            "Cricket","Football","Hockey","Volleyball",
            "the first Muslim president of India","first vice president of India","first president of Indian National Congress","first speaker of Lok Sabha",
            "Earthquakes","Rainfall","Ocean depth","Sound intensity"
    };
    int flag=0;
    public static int marks1=0,correct1=0,wrong1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_knw);

        final TextView score1 = (TextView)findViewById(R.id.textView4a);




        btnQ1=(Button)findViewById(R.id.btnQ1);
        btnquit1=(Button)findViewById(R.id.btnquit1);
        tv1=(TextView) findViewById(R.id.tvque1);

        answersgrp1=(RadioGroup)findViewById(R.id.answersgrp1);
        radioBtn1=(RadioButton)findViewById(R.id.radioBtn1);
        radioBtn2=(RadioButton)findViewById(R.id.radioBtn2);
        radioBtn3=(RadioButton)findViewById(R.id.radioBtn3);
        radioBtn4=(RadioButton)findViewById(R.id.radioBtn4);

        tv1.setText(questions1[flag]);
        radioBtn1.setText(opt1[0]);
        radioBtn2.setText(opt1[1]);
        radioBtn3.setText(opt1[2]);
        radioBtn4.setText(opt1[3]);
        btnQ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(answersgrp1.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans1 = (RadioButton) findViewById(answersgrp1.getCheckedRadioButtonId());
                String ansText1 = uans1.getText().toString();

                if(ansText1.equals(answers1[flag])) {
                    correct1++;
                    Toast.makeText(General_knw.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong1++;
                    Toast.makeText(General_knw.this, "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score1 != null)
                    score1.setText(""+correct1);

                if(flag<questions1.length)
                {
                    tv1.setText(questions1[flag]);
                    radioBtn1.setText(opt1[flag*4]);
                    radioBtn2.setText(opt1[flag*4 +1]);
                    radioBtn3.setText(opt1[flag*4 +2]);
                    radioBtn4.setText(opt1[flag*4 +3]);
                }
                else
                {
                    marks1=correct1;
                    Intent in = new Intent(General_knw.this,Result1.class);
                    startActivity(in);
                }
                answersgrp1.clearCheck();
            }
        });

        btnquit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(General_knw.this,Result1.class);
                startActivity(intent);
            }
        });
    }
    }
