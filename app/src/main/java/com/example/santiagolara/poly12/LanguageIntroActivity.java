package com.example.santiagolara.poly12;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class LanguageIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_intro);

        Intent intent = getIntent();
        String language = intent.getStringExtra(MainActivity.LANGUAGE_NAME);

        TextView header = (TextView) findViewById(R.id.header);
        header.setText("Welcome to your first lesson in " + language + "!");

        TextView paragraph = (TextView) findViewById(R.id.paragraph);
        paragraph.setText("     This is your introduction to " + language + ". Before we get started, " +
                "we would like to get a feel for what kind of learner you are. Please take the time to take a quick survey on" +
                " the different learning options we provide such as: Audio, Visual or Mixed learning. ");

        ImageButton visual = (ImageButton) findViewById(R.id.visualButton);
        ImageButton audio = (ImageButton) findViewById(R.id.audioButton);
        ImageButton mixed = (ImageButton) findViewById(R.id.mixedButton);
    }

}
