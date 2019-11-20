package com.example.santiagolara.poly12;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Select_SpanishActivity extends AppCompatActivity {
    public static final String LANGUAGE_NAME = "com.example.santiagolara.poly12";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_spanish);

        Intent intent = getIntent();
        final String language = intent.getStringExtra(SelectLanguageActivity.LANGUAGE_NAME);

        Button newLanguage = (Button) findViewById(R.id.newLanguage);
        newLanguage.setText("New to " + language +"?");

        newLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Select_SpanishActivity.this, LanguageIntroActivity.class);
                intent.putExtra(LANGUAGE_NAME, language);
                startActivity(intent);
            }
        });

        Button knowLanguage = (Button) findViewById(R.id.knowLanguage);
        knowLanguage.setText("Already know some " + language + "?");

        knowLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMain3Activity();
            }
        });
    }

    public void openMain3Activity() {
        Intent intent = new Intent(this, SpanishTest_BasicActivity.class);
        startActivity(intent);
    }
}
