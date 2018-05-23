package com.example.francisco.example;

/**
 * Created by francisco on 2018-05-22.
 */

class Question {

    private String text;
    private String rightAnswer;
    private String otherAnswer;

    public Question(String text, String rightAnswer, String otherAnswer) {
        this.text = text;
        this.rightAnswer = rightAnswer;
        this.otherAnswer = otherAnswer;
    }

    public String getText() {
        return text;
    }

    public String getOtherAnswer() {
        return otherAnswer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }
}
