package com.example.caiomagno.surveyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by caiomagno on 13/01/17.
 */

public class QuestionViewBuilder {
    private Context context;

    public QuestionViewBuilder(Context context) {
        this.context = context;
    }

    public View buildQuestionView(Question question, int index){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View questionView = layoutInflater.inflate(R.layout.question_layout, null);

        TextView questionHeadTextView = (TextView) questionView.findViewById(R.id.questionHeadTextView);
        TextView textQuestionTextView = (TextView) questionView.findViewById(R.id.textQuestionTextView);
        RadioGroup radioGroup = (RadioGroup) questionView.findViewById(R.id.optionsRadioGroup);

        questionHeadTextView.setText(questionHeadTextView.getText() + String.valueOf(index));
        textQuestionTextView.setText(question.getText());

        for (Options option:question.getOptionsList()) {
            RadioButton optionRadioButton = new RadioButton(this.context);
            optionRadioButton.setText(option.getText());
            optionRadioButton.setId(Integer.parseInt(option.getNum()));
            radioGroup.addView(optionRadioButton);
        }

        return questionView;
    }

    protected  void addQuestionToActivity(LinearLayout parent, Question question, int index){
        if(parent.getChildCount() > 0){
            parent.removeViewAt(0);
        }
        LinearLayout questionView = (LinearLayout) this.buildQuestionView(question, index);

        parent.addView(questionView);
    }
}
