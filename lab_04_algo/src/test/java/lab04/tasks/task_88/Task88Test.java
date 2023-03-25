package lab04.tasks.task_88;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task88Test {

    @Test
    void divide1() throws DivisionByZero {
        assertEquals(1, new Task88().divide(2, 2));
    }

    @Test
    void divide2() throws DivisionByZero {
        assertEquals(5, new Task88().divide(17, 3));
    }

    @Test
    void divide3() throws DivisionByZero {
        assertEquals(9, new Task88().divide(81, 9));
    }

    @Test
    void divide4() throws DivisionByZero {
        assertEquals(0, new Task88().divide(0, 1));
    }

    @Test
    void divide5() {
        assertThrows(DivisionByZero.class, () -> {
            new Task88().divide(1, 0);
        });
    }
}