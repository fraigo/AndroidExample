package com.example.francisco.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButton1, mButton2;
    private TextView mLabel1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // To restore any previous state of the application when is closed
        super.onCreate(savedInstanceState);
        // Inflates the main layout from xml to the application view
        setContentView(R.layout.activity_main);

        // To retrieve elements from the main layout using IDs
        mButton1 = findViewById(R.id.answer1Button);
        mButton2 = findViewById(R.id.answer2Button);
        mLabel1 = findViewById(R.id.titleLabel);


        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLabel1.setText("Clicked 1");
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLabel1.setText("Clicked 2");
            }
        });

        //Another way to do it using Lambda Expressions
        //mButton1.setOnClickListener( (v) -> { mLabel1.setText("Clicked 1");});
        //mButton2.setOnClickListener( (v) -> { mLabel1.setText("Clicked 2");});


    }
}
