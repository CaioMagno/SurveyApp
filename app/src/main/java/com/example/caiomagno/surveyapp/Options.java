package com.example.caiomagno.surveyapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Options implements Serializable{
    private String num;
    private String text;
    private int mData;

    public Options(String num, String text){
        this.num = num;
        this.text = text;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(mData);
//    }
//
//    public static final Parcelable.Creator<Options> CREATOR
//            = new Parcelable.Creator<Options>() {
//        public Options createFromParcel(Parcel in) {
//            return new Options(in);
//        }
//
//        public Options[] newArray(int size) {
//            return new Options[size];
//        }
//    };
//
//    private Options(Parcel in) {
//        mData = in.readInt();
//    }
}
