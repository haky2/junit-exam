package com.haky.ch12;

import lombok.Getter;

@Getter
public class Answer {
    private Question question;

    public Answer(Question question, Bool bool) {}

    public boolean match(Answer otherAnswer) {
        return otherAnswer != null;
        //        return question.match(i, otherAnswer.i);
    }

    public String getQuestionText() {
        return "just test";
    }
}
