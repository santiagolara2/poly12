package com.example.santiagolara.poly12;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SelectLanguageActivity extends AppCompatActivity {
    int currentItem = 0;
    public static final String LANGUAGE_NAME = "com.example.santiagolara.poly12";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);

        final Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(SelectLanguageActivity.this,
            android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Languages));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(currentItem==position) {
                    return; //do nothing
                }else{
                    String language = mySpinner.getSelectedItem().toString();
                    Intent intent =  new Intent(SelectLanguageActivity.this,Select_SpanishActivity.class);
                    intent.putExtra(LANGUAGE_NAME, language);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        }


        }
