package lab04.tasks.task_257;

import java.util.Arrays;
/**
* Problem 257
This problem was asked by WhatsApp.

Given an array of integers out of order,
determine the bounds of the smallest window that must be sorted in order for the entire array to be sorted.
For example, given [3, 7, 5, 6, 9], you should return (1, 3).
* */
public class Task257 {

    public int[] boundsOfSmallestWindowToSort(int[] tab) {
        int[] sorted_tab = Arrays.stream(tab).sorted().toArray();
        int[] bounds;
        int start = -1;
        int end = -1;

        if (Arrays.equals(sorted_tab, tab)) {
            return new int[]{-1, -1};
        }

        for (int i = 0; i < sorted_tab.length; i++) {
            if (sorted_tab[i] != tab[i]) {
                start = i;
                break;
            }
        }

        for (int i = start; i < sorted_tab.length; i++) {
            if (sorted_tab[i] != tab[i]) {
                end = i;
            }
        }

        return new int[]{start, end};
    }
}
