package com.example.francisco.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mButton1, mButton2;
    private TextView mLabel1;
    private ArrayList<Question> questions;
    private int questionNumber;
    private Question currentQuestion;

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

        questions = new ArrayList<Question>();
        questions.add(new Question("Current year is","2018", "2017"));
        questions.add(new Question("2 x 3 x 4 x 5","120", "13"));
        questions.add(new Question("Roses are","Red", "Blue"));

        questionNumber = -1;
        nextQuestion();

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(mButton1);
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(mButton2);
            }
        });

        //Another way to do it using Lambda Expressions (Java 8)
        //mButton1.setOnClickListener( (v) -> { mLabel1.setText("Clicked 1");});
        //mButton2.setOnClickListener( (v) -> { mLabel1.setText("Clicked 2");});


    }

    private void checkAnswer(Button button1){
        if (button1.getText().equals(currentQuestion.getRightAnswer())){
            Toast.makeText(this, "Right!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        nextQuestion();
    }

    private void nextQuestion() {
        questionNumber++;
        if (questionNumber==questions.size()){
            questionNumber = 0;
        }
        this.setTitle("Quiz App - Question "+ (questionNumber+1));
        currentQuestion = questions.get(questionNumber);
        mLabel1.setText(currentQuestion.getText());
        if (Math.random()>0.5d) {
            mButton1.setText(currentQuestion.getRightAnswer());
            mButton2.setText(currentQuestion.getOtherAnswer());
        }else{
            mButton2.setText(currentQuestion.getRightAnswer());
            mButton1.setText(currentQuestion.getOtherAnswer());
        }
    }
}
