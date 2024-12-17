package com.example.project_quiz_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AnswersAdapter extends android.widget.BaseAdapter {
    private final Context context;
    private final List<Question> questionList;

    public AnswersAdapter(Context context, List<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
    }

    @Override
    public int getCount() {
        return questionList.size();
    }

    @Override
    public Object getItem(int position) {
        return questionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_answer, parent, false);
        }

        Question question = questionList.get(position);

        TextView tvQuestion = convertView.findViewById(R.id.tvAnswerQuestion);
        TextView tvCorrectAnswer = convertView.findViewById(R.id.tvCorrectAnswer);
        TextView tvSelectedAnswer = convertView.findViewById(R.id.tvSelectedAnswer);

        tvQuestion.setText(question.getQuestionText());
        tvCorrectAnswer.setText("Correct: " + question.getCorrectAnswer());
        tvSelectedAnswer.setText("Your Answer: " + question.getSelectedAnswer());

        return convertView;
    }
}
