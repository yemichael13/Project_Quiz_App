package com.example.project_quiz_app;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    TextView tvScore;
    Button btnViewAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvScore = findViewById(R.id.tvScore);
        btnViewAnswers = findViewById(R.id.btnViewAnswers);

        // Get the score from QuizActivity
        int score = getIntent().getIntExtra("score", 0);

        // Display the score
        tvScore.setText("Your Score: " + score + "/20");

        // Button to view correct answers
        btnViewAnswers.setOnClickListener(v -> {
            Intent intent = new Intent(this, AnswersActivity.class);
            startActivity(intent);
        });
    }
}
