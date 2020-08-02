package com.haky.ch1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hakyoung lee
 */
class ScoreCollectionTest {

    @Test
    public void test() {
//        fail("Not yet implemented");
    }

    @Test
    public void answersArithmeticMeanOfTwoNumbers() {

        // arrange
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        // act
        int actualResult = collection.arithmeticMean();

        // assert
        assertThat(actualResult, equalTo(7));
    }
}