package com.example.android.simplequizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Button mReplay;
    TextView totalCorrect;
    TextView totalIncorrect;
    TextView mQuitMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        totalCorrect = findViewById(R.id.correctAnswers);
        totalIncorrect = findViewById(R.id.incorrectAnswers);
        mReplay = findViewById(R.id.replay);
        mQuitMessage = findViewById(R.id.quitMessage);

        Intent intent = getIntent();
        String quit= intent.getStringExtra("quitMessage");
        mQuitMessage.setText(quit);

        StringBuffer sb = new StringBuffer();
        sb.append("Total Correct answers: "+ QuestionActivity.correctAnwers + "\n");

        StringBuffer sb2 = new StringBuffer();
        sb2.append("Total Incorrect answers: "+ QuestionActivity.incorrectAnswers + "\n");

        totalCorrect.setText(sb);
        totalIncorrect.setText(sb2);

        QuestionActivity.correctAnwers = 0;
        QuestionActivity.incorrectAnswers = 0;

        mReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newInt = new Intent(ResultActivity.this,MainActivity.class);
                startActivity(newInt);
                finish();
            }
        });
    }
}
