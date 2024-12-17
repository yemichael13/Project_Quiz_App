package com.example.project_quiz_app;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AnswersActivity extends AppCompatActivity {
    private ListView listViewAnswers;
    private ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        listViewAnswers = findViewById(R.id.listViewAnswers);

        questionList = getIntent().getParcelableArrayListExtra("questions");

        AnswersAdapter answersAdapter = new AnswersAdapter(this, questionList);
        listViewAnswers.setAdapter(answersAdapter);
    }
}
