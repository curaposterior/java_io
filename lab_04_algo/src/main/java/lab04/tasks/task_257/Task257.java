package lab04.tasks.task_257;

import java.util.Arrays;

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
