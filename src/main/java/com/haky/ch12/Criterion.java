package com.haky.ch12;

import lombok.Getter;

@Getter
public class Criterion {
    private Answer answer;
    public Criterion(Answer answer, Weight dontCare) {}
}
