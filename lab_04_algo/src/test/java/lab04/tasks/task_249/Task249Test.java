package lab04.tasks.task_249;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task249Test {

    @Test
    void findMaxXOR1() {
        assertEquals(7, new Task249().findMaxXOR(new int[]{1, 2, 3, 4}));
    }

    @Test
    void findMaxXOR2() {
        assertEquals(212898, new Task249().findMaxXOR(new int[]{3723, 7589, 205319, 1620}));
    }

    @Test
    void findMaxXOR3() {
        assertEquals(159196, new Task249().findMaxXOR(new int[]{9589, 2528, 158106, 1094}));
    }

    @Test
    void findMaxXOR4() {
        assertEquals(212158, new Task249().findMaxXOR(new int[]{616, 2403, 212694, 1487}));
    }

    @Test
    void findMaxXOR5() {
        assertEquals(80612, new Task249().findMaxXOR(new int[]{9914, 4459, 72798, 1276}));
    }

    @Test
    void findMaxXOR6() {
        assertEquals(11159, new Task249().findMaxXOR(new int[]{2756, 8531, 490, 1954}));
    }
}