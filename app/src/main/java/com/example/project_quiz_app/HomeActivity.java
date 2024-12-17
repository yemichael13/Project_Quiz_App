package com.example.project_quiz_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private Button btnStartQuiz, btnLogout;
    TextView tvWelcome;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvWelcome = findViewById(R.id.tvWelcome);
        dbHelper = new DBHelper(this);
        btnStartQuiz = findViewById(R.id.btnStartQuiz);
        btnLogout = findViewById(R.id.btnLogout);

        // Retrieve username from Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        if (username != null) {
            // Fetch the username from the database (optional)
            String fetchedUsername = dbHelper.getUsername(username);

            // Display the username
            tvWelcome.setText(fetchedUsername + "!");
        }

        // Start QuizActivity when the button is clicked
        btnStartQuiz.setOnClickListener(v -> {
            Intent startQuizIntent = new Intent(HomeActivity.this, QuizActivity.class);
            startActivity(startQuizIntent);
        });

        // Log out and navigate back to LoginActivity
        btnLogout.setOnClickListener(v -> {
            Intent logoutIntent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(logoutIntent);
            finish(); // Close HomeActivity
        });
    }
}
