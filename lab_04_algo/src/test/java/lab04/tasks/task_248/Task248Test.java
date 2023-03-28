package lab04.tasks.task_248;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Task248Test {

    @Test
    void max1() {
        assertEquals(2, new Task248().max(1, 2));
    }

    @Test
    void max2() {
        assertNotEquals(10, new Task248().max(100, 20));
    }

    @Test
    void max3() {
        assertTrue(99 == new Task248().max(98, 99));
    }
}