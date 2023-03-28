package lab04.tasks.task_48;

import java.util.List;


public class Task48 {

    public static BinaryTree generate_tree(List<Integer> preorder, List<Integer> inorder) {
        int n = preorder.size();
        if (n != inorder.size()) {
            throw new IllegalArgumentException("Arrays should be equal");
        }
        if (n == 0) {
            return new BinaryTree();
        }
        int root = preorder.get(0);
        BinaryTree tree = new BinaryTree();
        tree.put(root);
        if (n > 1) {
            int i = inorder.indexOf(root);

            var inorder_left = inorder.subList(0, i);
            var preorder_left = preorder.subList(1, i + 1);
            var inorder_right = inorder.subList(i + 1, n);
            var preorder_right = preorder.subList(i + 1, n);


            BinaryTree tree_left = generate_tree(preorder_left, inorder_left);
            BinaryTree tree_right = generate_tree(preorder_right, inorder_right);

            tree.getRoot().left = tree_left.getRoot();
            tree.getRoot().right = tree_right.getRoot();
        }
        return tree;
    }
}
