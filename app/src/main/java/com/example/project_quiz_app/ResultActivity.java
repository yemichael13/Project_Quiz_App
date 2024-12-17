package com.example.project_quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView tvScore = findViewById(R.id.tvScore);
        int score = getIntent().getIntExtra("score", 0);
        tvScore.setText("Your Score: " + score + "/20");

        TextView comment = findViewById(R.id.greatJob);
        if(score < 5){
            comment.setText("Not Bad");
        } else if (score <= 10) {
            comment.setText("Good");
        } else if (score <= 18) {
            comment.setText("Great Job");
        } else{
            comment.setText("Exelent");
        }

        Button btnViewAnswers = findViewById(R.id.btnViewAnswers);
        btnViewAnswers.setOnClickListener(view -> {
            Intent intent = new Intent(ResultActivity.this, AnswersActivity.class);
            startActivity(intent);
        });
    }
}

