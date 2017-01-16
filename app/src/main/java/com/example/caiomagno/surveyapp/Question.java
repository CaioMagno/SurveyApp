package com.example.caiomagno.surveyapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {
    private int mData;
    private String text;
    private ArrayList<Options> optionsList;

    public Question() {
    }

    public Question(String text, ArrayList<Options> optionsList) {
        this.text = text;
        this.optionsList = optionsList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(ArrayList<Options> optionsList) {
        this.optionsList = optionsList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", optionsList=" + optionsList +
                '}';
    }
}
