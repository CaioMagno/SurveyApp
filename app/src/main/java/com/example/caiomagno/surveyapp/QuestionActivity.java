package com.example.caiomagno.surveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class QuestionActivity extends AppCompatActivity {

    private int currentQuestionIndex;
    private Button nextQuestionButton;
    private Button previousQuestionButton;
    private RadioGroup optionsRadioGroup;

    private Question question;
    private QuestionViewBuilder questionViewBuilder;
    private ArrayList<Integer> answersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        currentQuestionIndex = getIntent().getIntExtra("QUESTION_INDEX", 1);
        final ArrayList<Question> questionArrayList = (ArrayList<Question>) getIntent().getSerializableExtra("QUESTIONS");
        final Iterator<Question> questionIterator = questionArrayList.iterator();

        question = questionIterator.next();
        answersList = new ArrayList<Integer>();

        questionViewBuilder = new QuestionViewBuilder(this);

        final LinearLayout contentQuestionLinearLayout = (LinearLayout) findViewById(R.id.contentQuestionLinearLayout);
        nextQuestionButton = (Button) findViewById(R.id.nextQuestionButton);
        previousQuestionButton = (Button) findViewById(R.id.previousQuestionButton);

        nextQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionsRadioGroup = (RadioGroup) findViewById(R.id.optionsRadioGroup);
                if(optionsRadioGroup.getCheckedRadioButtonId() != -1){
                    answersList.add(optionsRadioGroup.getCheckedRadioButtonId());

                    if(currentQuestionIndex < questionArrayList.size()-1){
                        currentQuestionIndex++;
                        question = questionArrayList.get(currentQuestionIndex);
                        questionViewBuilder.addQuestionToActivity(contentQuestionLinearLayout, question, currentQuestionIndex+1);

                    } else {
                        Toast.makeText(QuestionActivity.this, "Fim da Pesquisa", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(QuestionActivity.this, "Marque uma alternativa", Toast.LENGTH_SHORT).show();
                }
            }
        });

        previousQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestionIndex > 0){
                    answersList.remove(answersList.size()-1);
                    currentQuestionIndex--;
                    question = questionArrayList.get(currentQuestionIndex);
                    questionViewBuilder.addQuestionToActivity(contentQuestionLinearLayout, question, currentQuestionIndex+1);

                } else {
                    Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        questionViewBuilder.addQuestionToActivity(contentQuestionLinearLayout, question, currentQuestionIndex+1);
    }

//    protected  void addQuestionToActivity(ViewGroup parent, Question question){
//        parent.removeViewAt(0);
//        QuestionViewBuilder questionViewBuilder = new QuestionViewBuilder(this);
//        LinearLayout questionView = (LinearLayout) questionViewBuilder.buildQuestionView(question, 1);
//
//        parent.addView(questionView);
//    }
}
