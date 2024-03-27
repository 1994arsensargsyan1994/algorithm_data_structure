package binar.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    private TreeNode root;
    private int size;

    public BinaryTree() {
    }

    public List<Integer> order(Order order) {
        List<Integer> integers = new ArrayList<>();
        dfs(this.root, integers, order);
        return integers;
    }


    private void dfs(TreeNode node, List<Integer> integers, Order order) {
        if (node == null) return;
        if (order.equals(Order.PRE)) integers.add(node.value);
        dfs(node.left, integers, order);

        if (order.equals(Order.IN)) integers.add(node.value);
        dfs(node.right, integers, order);

        if (order.equals(Order.POST)) integers.add(node.value);

    }

    public void insert(int value) {
        this.root = insert(this.root, value);
        System.out.println("kk");
    }

    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public void delete(int val) {
        delete(this.root, val);
    }

    private TreeNode delete(TreeNode node, int val) {
        if (node == null) return null;
        if (node.value < val) {
            node.right = delete(node.right, val);
        }
        if (node.value > val) {
            node.left = delete(node.left, val);
        } else {
            if (node.left == null) {
                return node.right;
            } else if ((node.right == null)) {
                return node.left;
            }
            TreeNode suce = getMin(node.right);
            node.value = suce.value;
            node.right = delete(node.right, val);
        }
        return node;
    }

    public List<List<Integer>> bfs(){
        if (this.root == null) return List.of();
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(this.root);
        int lavel = 0;
        while (!queue.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.peek();
                queue.poll();
                arr.add(node.value);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ++lavel;
            result.add(arr);
        }
        return result;
    }

    private TreeNode getMin(TreeNode right) {
        if (right == null) return null;
        return getMin(right.left);
    }

    private TreeNode getMax(TreeNode left) {
        if (left == null) return null;
        return getMin(left.right);
    }

    static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
