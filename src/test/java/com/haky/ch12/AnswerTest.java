package com.haky.ch12;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnswerTest {
    @Test
    public void matchAgainstNullAnswerReturnsFalse() {
        assertFalse(new Answer(new BooleanQuestion(0, ""), Bool.TRUE).match(null));
    }
}