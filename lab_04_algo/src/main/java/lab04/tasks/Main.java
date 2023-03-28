package lab04.tasks;


import lab04.tasks.task_248.Task248;
import lab04.tasks.task_249.Task249;
import lab04.tasks.task_257.Task257;
import lab04.tasks.task_273.Task273;
import lab04.tasks.task_48.BinaryTree;
import lab04.tasks.task_48.Task48;
import lab04.tasks.task_61.Task61;
import lab04.tasks.task_88.DivisionByZero;
import lab04.tasks.task_88.Task88;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws DivisionByZero {

        //task 48
        System.out.println("Task 48 preorder tree traversal for arrays preorder(1,2,4,5,3,6,7) and postorder(4,2,5,1,6,3,7");
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,2,4,5,3,6,7));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(4,2,5,1,6,3,7));
        BinaryTree tree = Task48.generate_tree(l1, l2);
        tree.preOrder(tree.getRoot());
        System.out.println(tree.preorderString);
        System.out.println();

        //task 61
        System.out.println("Task 61 fast exp. 2^5:");
        var task61 = new Task61().fastExponentation(2, 5);
        System.out.println(task61);
        System.out.println();

        //task 88
        System.out.println("Task 88 division (20/5) without certain operations:");
        var task88 = new Task88().divide(20, 5);
        System.out.println(task88);
        System.out.println();

        //task 248
        System.out.println("Task 248 max of two numbers (20, 10) without ceratain operations:");
        var task248 = new Task248().max(20, 10);
        System.out.println("Max of 20 and 10: " + task248);
        System.out.println();

        //task 249
        System.out.println("Task 249 max xor of two numbers (30, 40)");
        var task249 = new Task249().findMaxXOR(new int[] {30, 40});
        System.out.println("Max xor of 30 and 40: " + task249);
        System.out.println();

        //task 257
        System.out.println("Task 257 bounds of smallest window to sort in array 1,2,4,7,3,9,8:");
        var task257 = new Task257().boundsOfSmallestWindowToSort(new int[] {1,2,4,7,3,9,8});
        System.out.println(Arrays.toString(task257));
        System.out.println();
        //task 273
        System.out.println("Task 273 check if array (-2,1,2,3,4) has fixed point:");
        var task273 = new Task273().fixedPoint(new int[] {-2,1,2,3,4});
        System.out.println("Array -2,1,2,3,4 has fixed point: " + task273);
    }
}