package com.example.santiagolara.poly12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartScreenActivity extends AppCompatActivity {
    private Button Enter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        Enter = (Button)findViewById(R.id.btGo2SignUp); //Set for this for now - will change to begin asking if user is new/ask for first time language

        Enter.setOnClickListener(new View.OnClickListener() { //Click on Enter, move on to next page -> Change this
            @Override
            public void onClick(View v){
                startActivity(new Intent(StartScreenActivity.this, SelectLanguageActivity.class)); //Temporary redirect, find a way to check if user if logged in first
            }
        });
    }
}
