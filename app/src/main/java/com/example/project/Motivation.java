package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Motivation extends AppCompatActivity {

    private Button motiButton;
    private TextView motiText;


    private static final String ACTIVITY_NAME = "Motivation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivation);

        motiText = findViewById(R.id.textView);
        motiButton = findViewById(R.id.motivation);

        String[] quotes = {"Do not save what is left after spending, but spend what is left after saving.",
                            "Never spend your money before you have it.",
                                "He who buys what he does not need, steals from himself.",
                                "The price of anything is the amount of life you exchange for it."};



        motiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = (int) (Math.random()*4);
                motiText.setText(quotes[i]);
            }
        });


    }
}