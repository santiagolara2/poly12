package com.example.santiagolara.poly12;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class Main3Activity extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;

    TextView txtQuestion, txtTimer;
    int total = 1;
    int correct = 0;
    int wrong = 0 ;

    DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);
        txtQuestion = (TextView) findViewById(R.id.question);
        txtTimer = (TextView) findViewById(R.id.Timer);



        updateQuestion();



    }

    private void updateQuestion() {

        total++;
        if (total>4){

        }else {
            reference = FirebaseDatabase.getInstance().getReference().child("Questions")
                .child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final Questions question = dataSnapshot.getValue(Questions.class);
                    txtQuestion.setText(question.getQuestion());

                    answer1.setText(question.getOption1());
                    answer2.setText(question.getOption2());
                    answer3.setText(question.getOption3());
                    answer4.setText(question.getOption4());


                    answer1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (answer1.getText().equals(question.getAnswer())){
                                answer1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        answer1.setBackgroundColor(Color.parseColor("#03A9F4"));

                                        updateQuestion();


                                    }
                                },1500);
                            }else{
                                wrong++;
                                answer1.setBackgroundColor(Color.RED);
                                if (answer2.getText().equals(question.getAnswer())){
                                    answer2.setBackgroundColor(Color.GREEN);
                                }
                                else if (answer3.getText().equals(question.getAnswer())){
                                    answer3.setBackgroundColor(Color.GREEN);

                                }
                                else if (answer4.getText().equals(question.getAnswer())){
                                    answer4.setBackgroundColor(Color.GREEN);

                                }
                            }
                        }
                    });



                    answer2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (answer2.getText().equals(question.getAnswer())){
                                answer2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        answer2.setBackgroundColor(Color.parseColor("#03A9F4"));


                                        updateQuestion();

                                    }
                                },1500);
                            }else{
                                wrong++;
                                answer1.setBackgroundColor(Color.RED);

                                if (answer1.getText().equals(question.getAnswer())){
                                    answer1.setBackgroundColor(Color.GREEN);
                                }
                                else if (answer3.getText().equals(question.getAnswer())){
                                    answer3.setBackgroundColor(Color.GREEN);

                                }
                                else if (answer4.getText().equals(question.getAnswer())){
                                    answer4.setBackgroundColor(Color.GREEN);

                                }
                            }
                        }
                    });


                    answer3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (answer3.getText().equals(question.getAnswer())){
                                answer3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        answer3.setBackgroundColor(Color.parseColor("#03A9F4"));


                                        updateQuestion();

                                    }
                                },1500);
                            }else{
                                wrong++;
                                answer3.setBackgroundColor(Color.RED);

                                if (answer1.getText().equals(question.getAnswer())){
                                    answer1.setBackgroundColor(Color.GREEN);
                                }
                                else if (answer2.getText().equals(question.getAnswer())){
                                    answer2.setBackgroundColor(Color.GREEN);

                                }
                                else if (answer4.getText().equals(question.getAnswer())){
                                    answer4.setBackgroundColor(Color.GREEN);

                                }
                            }
                        }
                    });


                    answer4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (answer4.getText().equals(question.getAnswer())){
                                answer4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        answer4.setBackgroundColor(Color.parseColor("#03A9F4"));


                                        updateQuestion();

                                    }
                                },1500);
                            }else{
                                wrong++;
                                answer4.setBackgroundColor(Color.RED);

                                if (answer1.getText().equals(question.getAnswer())){
                                    answer1.setBackgroundColor(Color.GREEN);
                                }
                                else if (answer2.getText().equals(question.getAnswer())){
                                    answer2.setBackgroundColor(Color.GREEN);

                                }
                                else if (answer3.getText().equals(question.getAnswer())){
                                    answer3.setBackgroundColor(Color.GREEN);

                                }
                            }
                        }
                    });






                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }


    }

