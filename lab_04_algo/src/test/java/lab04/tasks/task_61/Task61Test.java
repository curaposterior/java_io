package lab04.tasks.task_61;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task61Test {

    @Test
    void fastExponentationTest1() {
        int a = 7;
        int b = 9;
        assertEquals(40353607, new Task61().fastExponentation(a, b));
    }

    @Test
    void fastExponentationTest2() {
        int a = 2;
        int b = 10;
        assertEquals(1024, new Task61().fastExponentation(a, b));
    }

    @Test
    void fastExponentationTest3() {
        int a = 16;
        int b = 4;
        assertEquals(65536, new Task61().fastExponentation(a, b));
    }

    @Test
    void fastExponentationTest4() {
        int a = 4;
        int b = 5;
        assertEquals(1024, new Task61().fastExponentation(a, b));
    }

    @Test
    void fastExponentationTest5() {
        int a = 3;
        int b = 3;
        assertEquals(27, new Task61().fastExponentation(a, b));
    }
}