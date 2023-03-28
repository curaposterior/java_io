package lab04.tasks.task_48;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task48Test {
    @Test
    void generate_tree1() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,4,5,3,6,7));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4,2,5,1,6,3,7));
        BinaryTree tree = lab04.tasks.task_48.Task48.generate_tree(l1, l2);
        tree.preOrder(tree.getRoot());
        assertEquals("1 2 4 5 3 6 7 ", tree.preorderString);
    }

    @Test
    void generate_tree2() {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,4,5,3,6));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4,2,5,1,6,3));
        BinaryTree tree = lab04.tasks.task_48.Task48.generate_tree(l1, l2);
        tree.preOrder(tree.getRoot());
        assertEquals("1 2 4 5 3 6 ", tree.preorderString);
    }

    @Test
    void generate_tree3_test_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            Task48.generate_tree(new ArrayList<>(Arrays.asList(1,2,4,5,3,6)),
                    new ArrayList<>(Arrays.asList(4,2,5,1,6,3,7)));
        });
    }
}