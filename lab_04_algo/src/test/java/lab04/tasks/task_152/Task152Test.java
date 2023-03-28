package lab04.tasks.task_152;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task152Test {
    public static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
    @Test
    void testGenerate1() {

        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Double> probs = new ArrayList<Double>(Arrays.asList(0.1, 0.5, 0.2, 0.2));
        ArrayList<Integer> generatedNums = new ArrayList<Integer>();

        Task152 cls = new Task152(nums, probs);

        for (int i = 0; i < 1000; i++) {
            generatedNums.add(cls.generate());
        }

        int size = nums.size();

        ArrayList<Double> calculateProbabilities = new ArrayList<Double>();
        for (int i = 0; i < size; i++) {
            double occurrences = Collections.frequency(generatedNums, nums.get(i));
            double prob = occurrences / generatedNums.size();
            calculateProbabilities.add(round(prob, 1));
        }
        assertEquals(probs, calculateProbabilities);
    }

    @Test
    void testGenerate2() {

        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(4, 10, 89, 14));
        ArrayList<Double> probs = new ArrayList<Double>(Arrays.asList(0.2, 0.4, 0.3, 0.1));
        ArrayList<Integer> generatedNums = new ArrayList<Integer>();
        DecimalFormat df = new DecimalFormat("#.#");

        Task152 cls = new Task152(nums, probs);

        for (int i = 0; i < 1000; i++) {
            generatedNums.add(cls.generate());
        }

        int size = nums.size();

        ArrayList<Double> calculateProbabilities = new ArrayList<Double>();
        for (int i = 0; i < size; i++) {
            double occurrences = Collections.frequency(generatedNums, nums.get(i));
            double prob = occurrences / generatedNums.size();
            calculateProbabilities.add(round(prob, 1));
        }
        assertEquals(probs, calculateProbabilities);
    }
}