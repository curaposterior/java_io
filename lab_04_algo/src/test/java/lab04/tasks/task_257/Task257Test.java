package lab04.tasks.task_257;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Task257Test {

    @Test
    void boundsOfSmallestWindowToSort1() {
        assertTrue(true, String.valueOf(Arrays.equals(new int[]{1, 3}, new Task257().boundsOfSmallestWindowToSort(new int[]{3,6,5,7,9}))));
    }

    @Test
    void boundsOfSmallestWindowToSort2() {
        assertTrue(true, String.valueOf(Arrays.equals(new int[]{2, 3}, new Task257().boundsOfSmallestWindowToSort(new int[]{3,5,7,6,9}))));
    }

    @Test
    void boundsOfSmallestWindowToSort3() {
        assertTrue(true, String.valueOf(Arrays.equals(new int[]{0, 4}, new Task257().boundsOfSmallestWindowToSort(new int[]{6,5,7,9,3}))));
    }

    @Test
    void boundsOfSmallestWindowToSort4() {
        assertTrue(true, String.valueOf(Arrays.equals(new int[]{1, 3}, new Task257().boundsOfSmallestWindowToSort(new int[]{5,7,9,6,10}))));
    }
}