package com.example.caiomagno.surveyapp;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by caiomagno on 13/01/17.
 */

public class Survey {
    public static ArrayList<Question> getSurvey(String filePath) throws ParserConfigurationException, SAXException, IOException {
        File inputFile = new File(filePath);
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();

        QuestionHandler questionHandler = new QuestionHandler();
        saxParser.parse(inputFile, questionHandler);

        ArrayList<Question> qlist = questionHandler.getQuestionsList();

        return qlist;
    }

    public static ArrayList<Question> getSurvey(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();

        QuestionHandler questionHandler = new QuestionHandler();
        saxParser.parse(inputStream, questionHandler);

        ArrayList<Question> qlist = questionHandler.getQuestionsList();

        return qlist;
    }
}
