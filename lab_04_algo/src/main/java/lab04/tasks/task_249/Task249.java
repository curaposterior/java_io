package lab04.tasks.task_249;

/*
* This problem was asked by Salesforce.

Given an array of integers, find the maximum XOR of any two elements.
* */

public class Task249 {

    public int findMaxXOR(int[] arr) {
        int size = arr.length;
        int maxXor = -Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                maxXor = Math.max(maxXor, arr[i] ^ arr[j]);
            }
        }
        return maxXor;
    }
}
