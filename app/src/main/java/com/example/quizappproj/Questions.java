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

public class Questions extends AppCompatActivity {
    TextView tv;
    Button btnQ, btnquit;
    RadioGroup answersgrp;
    RadioButton radioBtnA,radioBtnB,radioBtnC,radioBtnD;


    String questions[] = {
            "Which method can be defined only once in a program?",
            "Which of these is not a bitwise operator?",
            "Which keyword is used by method to refer to the object that invoked it?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package ‘pkg’?",
            "What is the return type of Constructors?",
            "Which of the following package stores all the standard java classes?",
            "Which of these method of class String is used to compare two String objects for their equality?",
            "An expression involving byte, int, & literal numbers is promoted to which of these?"
    };
    String answers[] = {"main method","<=","this","interface","public","import pkg.*","None of the mentioned","java","equals()","int"};
    String opt[] = {
            "finalize method","main method","static method","private method",
            "&","&=","|=","<=",
            "import","this","catch","abstract",
            "Interface","interface","intf","Intf",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned",
            "lang","java","util","java.packages",
            "equals()","Equals()","isequal()","Isequal()",
            "int","long","byte","float"
    };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);



        final TextView score = (TextView)findViewById(R.id.textView4);



        btnQ=(Button)findViewById(R.id.btnQ);
        btnquit=(Button)findViewById(R.id.btnquit);
        tv=(TextView) findViewById(R.id.tvque);

        answersgrp=(RadioGroup)findViewById(R.id.answersgrp);
        radioBtnA=(RadioButton)findViewById(R.id.radioBtnA);
        radioBtnB=(RadioButton)findViewById(R.id.radioBtnB);
        radioBtnC=(RadioButton)findViewById(R.id.radioBtnC);
        radioBtnD=(RadioButton)findViewById(R.id.radioBtnD);

        tv.setText(questions[flag]);

        radioBtnA.setText(opt[0]);
        radioBtnB.setText(opt[1]);
        radioBtnC.setText(opt[2]);
        radioBtnD.setText(opt[3]);
        btnQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(answersgrp.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select one choice", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(answersgrp.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(Questions.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(Questions.this, "Wrong", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    radioBtnA.setText(opt[flag*4]);
                    radioBtnB.setText(opt[flag*4 +1]);
                    radioBtnC.setText(opt[flag*4 +2]);
                    radioBtnD.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(Questions.this,Result.class);
                    startActivity(in);
                }
                answersgrp.clearCheck();
            }
        });

        btnquit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Questions.this,Result.class);
                startActivity(intent);
            }
        });
    }

}
