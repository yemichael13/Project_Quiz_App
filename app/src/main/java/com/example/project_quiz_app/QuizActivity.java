package com.example.project_quiz_app;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private QuestionAdapter adapter;
    private List<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of 20 questions
        questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", "Paris", "Berlin", "Madrid", "Rome", 0));
        questions.add(new Question("Who wrote 'Hamlet'?", "Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen", 1));
        questions.add(new Question("What is the largest planet in our solar system?", "Earth", "Jupiter", "Saturn", "Mars", 1));
        questions.add(new Question("What is the chemical symbol for water?", "O2", "H2O", "CO2", "HO", 1));
        questions.add(new Question("Which animal is known as the King of the Jungle?", "Tiger", "Elephant", "Lion", "Leopard", 2));
        questions.add(new Question("How many continents are there?", "5", "6", "7", "8", 2));
        questions.add(new Question("Which planet is known as the Red Planet?", "Venus", "Mars", "Saturn", "Mercury", 1));
        questions.add(new Question("What is the square root of 64?", "6", "7", "8", "9", 2));
        questions.add(new Question("Who painted the Mona Lisa?", "Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet", 0));
        questions.add(new Question("What is the largest ocean on Earth?", "Atlantic Ocean", "Indian Ocean", "Pacific Ocean", "Arctic Ocean", 2));
        questions.add(new Question("Which country is known for the Great Wall?", "India", "China", "Japan", "Russia", 1));
        questions.add(new Question("What is the smallest unit of life?", "Atom", "Molecule", "Cell", "Organ", 2));
        questions.add(new Question("What does DNA stand for?", "Deoxyribonucleic Acid", "Dinucleic Acid", "Dioxin Acid", "None of the above", 0));
        questions.add(new Question("What is the fastest land animal?", "Cheetah", "Lion", "Horse", "Gazelle", 0));
        questions.add(new Question("How many colors are there in a rainbow?", "5", "6", "7", "8", 2));
        questions.add(new Question("Which gas do plants absorb?", "Carbon Dioxide", "Oxygen", "Nitrogen", "Hydrogen", 0));
        questions.add(new Question("What is the capital city of Japan?", "Tokyo", "Osaka", "Kyoto", "Hiroshima", 0));
        questions.add(new Question("What is the hardest natural substance?", "Gold", "Iron", "Diamond", "Silver", 2));
        questions.add(new Question("What is the boiling point of water?", "50°C", "75°C", "100°C", "150°C", 2));
        questions.add(new Question("What is the national currency of the United States?", "Euro", "Dollar", "Pound", "Yen", 1));

        // Set the adapter with the list of questions
        adapter = new QuestionAdapter(questions);
        recyclerView.setAdapter(adapter);

        // Submit button
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(v -> {
            int score = calculateScore();
            Intent intent = new Intent(QuizActivity.this, AnswersActivity.class);
            intent.putExtra("questions", (Serializable) questions); // Pass questions to AnswersActivity
            intent.putExtra("score", score); // Pass score to AnswersActivity
            startActivity(intent);
        });
    }

    // Calculate the score based on selected answers
    private int calculateScore() {
        int score = 0;
        for (Question question : questions) {
            if (question.getSelectedAnswer() == question.getCorrectAnswer()) {
                score++;
            }
        }
        Toast.makeText(this, "Score: " + score, Toast.LENGTH_SHORT).show();
        return score;
    }
}
