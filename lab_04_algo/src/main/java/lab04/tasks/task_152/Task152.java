package lab04.tasks.task_152;

/*
Problem 152
This problem was asked by Triplebyte.

You are given n numbers as well as n probabilities that sum up to 1. Write a function to generate one of the numbers with its corresponding probability.

For example, given the numbers [1, 2, 3, 4] and probabilities [0.1, 0.5, 0.2, 0.2], your function should return 1 10% of the time, 2 50% of the time, and 3 and 4 20% of the time.

You can generate random numbers between 0 and 1 uniformly.
(source: https://github.com/ruppysuppy/Daily-Coding-Problem-Solutions)
* */

import java.util.ArrayList;

public class Task152 {
    private ArrayList<Integer> numbers;
    private ArrayList<Double> probabilities;

    public Task152(ArrayList<Integer> numbers, ArrayList<Double> probabilities) {
        this.numbers = numbers;
        this.probabilities = probabilities;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public ArrayList<Double> getProbabilities() {
        return probabilities;
    }

    public int generate() {
        double randomProbability = Math.random();
        double c = 0.0;
        for (int i = 0; i < this.numbers.size(); i++) {
            c += this.probabilities.get(i);
            if (c >= randomProbability) {
                return this.numbers.get(i);
            }
        }
        return -1;
    }
}
