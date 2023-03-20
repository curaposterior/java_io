package lab04.tasks.task_61;

public class Task61 {

    public int fastExponentation(int a, int b) {
        int w = 1;
        while (b > 0) {
            if (b % 2 ==1) {
                w *= a;
            }
            a *= a;
            b /= 2;
        }
        return w;
    }
}
