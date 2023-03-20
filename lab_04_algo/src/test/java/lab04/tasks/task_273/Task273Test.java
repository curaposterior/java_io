package lab04.tasks.task_273;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task273Test {

    @Test
    void fixedPoint1() {
        assertTrue(new Task273().fixedPoint(new int[]{0, 1, 2}));
    }

    @Test
    void fixedPoint2() {
        assertFalse(new Task273().fixedPoint(new int[]{1, 2, 3, 4}));
    }

    @Test
    void fixedPoint3() {
        assertFalse(new Task273().fixedPoint(new int[]{50, 51, 52, 53}));
    }
}