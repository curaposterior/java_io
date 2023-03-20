package lab04.tasks.task_88;
/*
Problem 88
This question was asked by ContextLogic.

Implement division of two positive integers without using the division, multiplication, or modulus operators.
Return the quotient as an integer, ignoring the remainder.
* */
public class Task88 {

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }

        int ret = 0;
        while (a > 0) {
            a -= b;
            if (a >= 0) {
                ret += 1;
            }
        }
        return ret;
    }
}
