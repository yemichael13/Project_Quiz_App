package com.example.project_quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(view -> {
            // Example: Calculate Score
            int score = 0;
            RadioButton q1Answer = findViewById(R.id.radio1_q1);
            RadioButton q2Answer = findViewById(R.id.radio1_q2);
            RadioButton q3Answer = findViewById(R.id.radio3_q3);
            RadioButton q4Answer = findViewById(R.id.radio4_q4);
            RadioButton q5Answer = findViewById(R.id.radio2_q5);
            RadioButton q6Answer = findViewById(R.id.radio4_q6);
            RadioButton q7Answer = findViewById(R.id.radio2_q7);
            RadioButton q8Answer = findViewById(R.id.radio2_q8);
            RadioButton q9Answer = findViewById(R.id.radio3_q9);
            RadioButton q10Answer = findViewById(R.id.radio3_q10);
            RadioButton q11Answer = findViewById(R.id.radio1_q11);
            RadioButton q12Answer = findViewById(R.id.radio2_q12);
            RadioButton q13Answer = findViewById(R.id.radio3_q13);
            RadioButton q14Answer = findViewById(R.id.radio2_q14);
            RadioButton q15Answer = findViewById(R.id.radio3_q15);
            RadioButton q16Answer = findViewById(R.id.radio2_q16);
            RadioButton q17Answer = findViewById(R.id.radio1_q17);
            RadioButton q18Answer = findViewById(R.id.radio4_q18);
            RadioButton q19Answer = findViewById(R.id.radio3_q19);
            RadioButton q20Answer = findViewById(R.id.radio1_q20);



            if (q1Answer.isChecked()) score++;
            if (q2Answer.isChecked()) score++;
            if (q3Answer.isChecked()) score++;
            if (q4Answer.isChecked()) score++;
            if (q5Answer.isChecked()) score++;
            if (q6Answer.isChecked()) score++;
            if (q7Answer.isChecked()) score++;
            if (q8Answer.isChecked()) score++;
            if (q9Answer.isChecked()) score++;
            if (q10Answer.isChecked()) score++;
            if (q11Answer.isChecked()) score++;
            if (q12Answer.isChecked()) score++;
            if (q13Answer.isChecked()) score++;
            if (q14Answer.isChecked()) score++;
            if (q15Answer.isChecked()) score++;
            if (q16Answer.isChecked()) score++;
            if (q17Answer.isChecked()) score++;
            if (q18Answer.isChecked()) score++;
            if (q19Answer.isChecked()) score++;
            if (q20Answer.isChecked()) score++;

            // Pass score to ResultActivity
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        });
    }
}

