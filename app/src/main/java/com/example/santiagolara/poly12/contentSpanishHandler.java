package com.example.santiagolara.poly12;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class contentSpanishHandler extends AppCompatActivity {

    private CardView introduction, Lesson1, Lesson2, Lesson3, Lesson4, Lesson5, Lesson6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_spanish);
        introduction = findViewById(R.id.introduction);
        // defining cards
        Lesson1 = findViewById(R.id.lesson1);
        Lesson2 = findViewById(R.id.lesson2);
        Lesson3 = findViewById(R.id.lesson3);
        Lesson4 = findViewById(R.id.lesson4);
        Lesson5 = findViewById(R.id.lesson5);
        Lesson6 = findViewById(R.id.lesson6);

        // Add onclick listeners

        introduction.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contentSpanishHandler.this, spanish_introduction.class);

                startActivity(intent);

            }
        });
        Lesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contentSpanishHandler.this, spanish_lesson1.class);

                startActivity(intent);

            }
        });
        Lesson2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contentSpanishHandler.this, spanish_lesson2.class);

                startActivity(intent);
            }
        });
        Lesson3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contentSpanishHandler.this, spanish_lesson3.class);

                startActivity(intent);
            }
        });
        Lesson4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contentSpanishHandler.this, spanish_lesson4.class);

                startActivity(intent);
            }
        });
        Lesson5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contentSpanishHandler.this, spanish_lesson5.class);

                startActivity(intent);
            }
        });
        Lesson6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contentSpanishHandler.this, spanish_lesson6.class);

                startActivity(intent);
            }
        });

    }

}
