package com.example.project_quiz_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;

import java.util.List;

public class QuestionAdapter extends android.widget.ArrayAdapter<Question> {
    private final List<Question> questions;

    public QuestionAdapter(Context context, List<Question> questions) {
        super(context, 0, questions);
        this.questions = questions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_question, parent, false);
        }

        Question question = getItem(position);

        TextView tvQuestion = convertView.findViewById(R.id.tvQuestion);
        RadioGroup radioGroupOptions = convertView.findViewById(R.id.rgOptions);
        RadioButton rbOption1 = convertView.findViewById(R.id.rbOption1);
        RadioButton rbOption2 = convertView.findViewById(R.id.rbOption2);
        RadioButton rbOption3 = convertView.findViewById(R.id.rbOption3);
        RadioButton rbOption4 = convertView.findViewById(R.id.rbOption4);

        // Set question text and options
        tvQuestion.setText(question.getQuestionText());
        rbOption1.setText(question.getOption1());
        rbOption2.setText(question.getOption2());
        rbOption3.setText(question.getOption3());
        rbOption4.setText(question.getOption4());

        // Reset radio group to avoid incorrect pre-selection
        radioGroupOptions.setOnCheckedChangeListener(null);
        radioGroupOptions.clearCheck();

        // Restore the previously selected answer (if any)
        Pair<Integer, RadioButton> selected = getSelectedOption(question, rbOption1, rbOption2, rbOption3, rbOption4);
        if (selected != null) {
            radioGroupOptions.check(selected.first);
        }

        // Save selected answer when user selects one
        radioGroupOptions.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedOption = group.findViewById(checkedId);
            if (selectedOption != null) {
                question.setSelectedAnswer(selectedOption.getText().toString());
            }
        });

        return convertView;
    }

    private Pair<Integer, RadioButton> getSelectedOption(Question question, RadioButton... options) {
        String selectedAnswer = question.getSelectedAnswer();
        for (int i = 0; i < options.length; i++) {
            if (options[i].getText().toString().equals(selectedAnswer)) {
                return new Pair<>(options[i].getId(), options[i]);
            }
        }
        return null;
    }
}
