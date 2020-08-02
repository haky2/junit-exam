package com.haky.ch1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hakyoung lee
 */
public class ScoreCollection {

    private List<Scoreable> scores = new ArrayList<>();

    public void add(Scoreable scoreable) {
        scores.add(scoreable);
    }

    public int arithmeticMean() {
        int total = scores.stream().mapToInt(Scoreable::getScore).sum();
        return total / scores.size();
    }
}
