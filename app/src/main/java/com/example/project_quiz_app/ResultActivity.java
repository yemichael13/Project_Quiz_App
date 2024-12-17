package com.example.project_quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private TextView tvScore, tvComment;
    private Button btnViewAnswers, btnRetry;
    private ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvScore = findViewById(R.id.tvScore);
        tvComment = findViewById(R.id.comment);
        btnViewAnswers = findViewById(R.id.btnViewAnswers);
        btnRetry = findViewById(R.id.btnRetry);

        Intent intent = getIntent();
        questionList = intent.getParcelableArrayListExtra("questions");

        int correctAnswers = calculateCorrectAnswers();
        tvScore.setText("Score: " + correctAnswers + "/" + questionList.size());

        // Set comments based on the score
        if (correctAnswers < 5) {
            tvComment.setText("Not Good. Try again");
        } else if (correctAnswers <= 10) {
            tvComment.setText("Good");
        } else if (correctAnswers <= 18) {
            tvComment.setText("Great");
        } else {
            tvComment.setText("Excellent");
        }

        btnViewAnswers.setOnClickListener(v -> {
            Intent answersIntent = new Intent(ResultActivity.this, AnswersActivity.class);
            answersIntent.putParcelableArrayListExtra("questions", questionList);
            startActivity(answersIntent);
        });

        btnRetry.setOnClickListener(v -> {
            Intent retryIntent = new Intent(ResultActivity.this, QuizActivity.class);
            startActivity(retryIntent);
            finish();
        });
    }

    private int calculateCorrectAnswers() {
        int score = 0;
        for (Question question : questionList) {
            if (question.getCorrectAnswer().equals(question.getSelectedAnswer())) {
                score++;
            }
        }
        return score;
    }
}
