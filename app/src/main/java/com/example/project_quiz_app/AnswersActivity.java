package com.example.project_quiz_app;



import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnswersActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private QuestionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve questions and score from the intent
        List<Question> questions = (List<Question>) getIntent().getSerializableExtra("questions");
        int score = getIntent().getIntExtra("score", 0);

        // Display the score
        TextView tvScore = findViewById(R.id.tvScore);
        tvScore.setText("Your Score: " + score + "/" + questions.size());

        // Set up the adapter to show questions with selected and correct answers
        adapter = new QuestionAdapter(questions);
        recyclerView.setAdapter(adapter);
    }
}
