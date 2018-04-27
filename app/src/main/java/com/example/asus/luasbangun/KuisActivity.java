package com.example.asus.luasbangun;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class KuisActivity extends AppCompatActivity {

    Button answer1,answer2,answer3,answer4;
    TextView question,score;

     private Question  mQuestions = new Question();
     private String mAnswer;
     private int mScore = 0;
     private int mQuestionsLength = mQuestions.mQuestion.length;


    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kuis);

        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        question = (TextView) findViewById(R.id.question);
        score = (TextView) findViewById(R.id.score);

        score.setText(mScore);
        updateQuestion(r.nextInt(mQuestionsLength));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer1.getText()==mAnswer){
                    mScore++;
                    score.setText(mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameover();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer2.getText()==mAnswer){
                    mScore++;
                    score.setText(mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameover();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer3.getText()==mAnswer){
                    mScore++;
                    score.setText(mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameover();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer4.getText()==mAnswer){
                    mScore++;
                    score.setText(mScore);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameover();
                }
            }
        });
    }

    private void updateQuestion(int num){
        question.setText(mQuestions.getQuestion(num));
        answer1.setText(mQuestions.getChoice1(num));
        answer2.setText(mQuestions.getChoice2(num));
        answer3.setText(mQuestions.getChoice3(num));
        answer4.setText(mQuestions.getChoice4(num));

        mAnswer = mQuestions.getCorrectAnswer(num);

    }

    public void gameover() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(KuisActivity.this);
        alertDialogBuilder
                .setMessage("Game Over! Your Score :" + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                startActivity(new Intent(getApplicationContext(), KuisActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
