package com.example.project_quiz_app;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {
    private final List<Question> questions;

    public QuestionAdapter(List<Question> questions) {
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.tvQuestion.setText(question.getQuestion());
        holder.rbOption1.setText(question.getOption1());
        holder.rbOption2.setText(question.getOption2());
        holder.rbOption3.setText(question.getOption3());
        holder.rbOption4.setText(question.getOption4());

        // Pre-select the previously selected answer (if any)
        int selectedAnswer = question.getSelectedAnswer();
        if (selectedAnswer != -1) {
            ((RadioButton) holder.radioGroup.getChildAt(selectedAnswer)).setChecked(true);
        } else {
            holder.radioGroup.clearCheck();
        }

        // Handle answer selection
        holder.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            int answerIndex = holder.radioGroup.indexOfChild(holder.itemView.findViewById(checkedId));
            question.setSelectedAnswer(answerIndex);
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestion;
        RadioGroup radioGroup;
        RadioButton rbOption1, rbOption2, rbOption3, rbOption4;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            radioGroup = itemView.findViewById(R.id.radioGroup);
            rbOption1 = itemView.findViewById(R.id.rbOption1);
            rbOption2 = itemView.findViewById(R.id.rbOption2);
            rbOption3 = itemView.findViewById(R.id.rbOption3);
            rbOption4 = itemView.findViewById(R.id.rbOption4);
        }
    }
}
