package com.example.project_quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private ListView listViewQuestions;
    private Button btnSubmit;
    private ArrayList<Question> questionList;
    private QuestionAdapter questionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        listViewQuestions = findViewById(R.id.listViewQuestions);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Initialize question list with 20 questions
        questionList = new ArrayList<>();
        populateQuestions();

        // Set up adapter for the ListView
        questionAdapter = new QuestionAdapter(this, questionList);
        listViewQuestions.setAdapter(questionAdapter);

        // Handle Submit button click
        btnSubmit.setOnClickListener(v -> {
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putParcelableArrayListExtra("questions", questionList);
            startActivity(intent);
            finish();
        });
    }

    private void populateQuestions() {
        questionList.add(new Question("What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "Paris"));
        questionList.add(new Question("Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Venus", "Mars"));
        questionList.add(new Question("Who wrote 'Hamlet'?", "Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen", "William Shakespeare"));
        questionList.add(new Question("What is the boiling point of water?", "90°C", "100°C", "110°C", "120°C", "100°C"));
        questionList.add(new Question("What is the largest ocean on Earth?", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean", "Pacific Ocean"));
        questionList.add(new Question("Which element has the chemical symbol 'O'?", "Oxygen", "Osmium", "Gold", "Hydrogen", "Oxygen"));
        questionList.add(new Question("Who painted the Mona Lisa?", "Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Claude Monet", "Leonardo da Vinci"));
        questionList.add(new Question("Which country is known as the Land of the Rising Sun?", "China", "India", "Japan", "Thailand", "Japan"));
        questionList.add(new Question("What is the largest mammal?", "Elephant", "Blue Whale", "Giraffe", "Hippopotamus", "Elephant"));
        questionList.add(new Question("Which gas do plants absorb during photosynthesis?", "Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen", "Carbon Dioxide"));
        questionList.add(new Question("What is the smallest prime number?", "0", "1", "2", "3", "2"));
        questionList.add(new Question("Which organ is responsible for pumping blood?", "Lungs", "Liver", "Brain", "Heart", "Heart"));
        questionList.add(new Question("Who discovered gravity?", "Albert Einstein", "Isaac Newton", "Galileo Galilei", "Nikola Tesla", "Isaac Newton"));
        questionList.add(new Question("What is the chemical symbol for water?", "O", "H", "H2O", "HO", "H2O"));
        questionList.add(new Question("What is the tallest mountain in the world?", "K2", "Mount Everest", "Kangchenjunga", "Makalu", "Mount Everest"));
        questionList.add(new Question("Which planet is closest to the sun?", "Earth", "Mars", "Mercury", "Venus", "Mercury"));
        questionList.add(new Question("What is the currency of Japan?", "Yuan", "Dollar", "Yen", "Won", "Yen"));
        questionList.add(new Question("Who is known as the Father of Computers?", "Charles Babbage", "Alan Turing", "John von Neumann", "Ada Lovelace", "Charles Babbage"));
        questionList.add(new Question("Which continent is known as the Dark Continent?", "Asia", "Africa", "Australia", "Europe", "Africa"));
        questionList.add(new Question("What is the hardest natural substance on Earth?", "Gold", "Iron", "Diamond", "Silver", "Diamond"));
    }
}
