package lab04.tasks.task_248;

/**
* This problem was asked by Nvidia.

Find the maximum of two numbers without using any if-else statements, branching, or direct comparisons.
* */
public class Task248 {
    private final int CHAR_BIT = 4;
    private final int INT_BIT = 8;

    /**
    * The 1989 ANSI C specification doesn’t specify the result of signed right-shift, so below method is not portable
    * */
    public int max(int x, int y) {
        return x - ((x - y) & ((x - y) >>
                (INT_BIT * CHAR_BIT - 1)));
    }
}
