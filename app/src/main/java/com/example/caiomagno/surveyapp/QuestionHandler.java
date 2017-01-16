package com.example.caiomagno.surveyapp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class QuestionHandler extends DefaultHandler {
    private static final String QUESTION_TAG = "question";
    private static final String TEXT_TAG = "text";
    private static final String OPTION_TAG = "option";
    private static final String OPTION_NUMBER_TAG = "n";

    private String question_text;
    private ArrayList<Options> optionsList = new ArrayList<>();
    private String optNum;

    private ArrayList<Question> questionsList;

    private boolean readingQuestion;
    private boolean readingText;
    private boolean readingOptions;

    @Override
    public void startDocument() throws SAXException {
        questionsList = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase(QUESTION_TAG)){
            readingQuestion = true;
            optionsList = new ArrayList<>();
        }
        else if(qName.equalsIgnoreCase(TEXT_TAG)){
            readingText = true;
        } else if(qName.equalsIgnoreCase(OPTION_TAG)){
            readingOptions = true;
            optNum = attributes.getValue(OPTION_NUMBER_TAG);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(readingText){
            question_text = new String(ch, start, length);
        } else if(readingOptions){
            String optText = new String(ch, start, length);
            optionsList.add(new Options(optNum, optText));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase(QUESTION_TAG)){
            readingQuestion = false;
            this.questionsList.add(new Question(this.question_text, optionsList));
        }
        else if(qName.equals(TEXT_TAG)){
            readingText = false;
        } else if(qName.equals(OPTION_TAG)){
            readingOptions = false;
        }
    }

    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }
}
