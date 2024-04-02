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
        if (order.equals(Order.PRE)) integers.add(node.getValue());
        dfs(node.getLeft(), integers, order);

        if (order.equals(Order.IN)) integers.add(node.getValue());
        dfs(node.getRight(), integers, order);

        if (order.equals(Order.POST)) integers.add(node.getValue());

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
        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }

    public void delete(int val) {
        delete(this.root, val);
    }

    private TreeNode delete(TreeNode node, int val) {
        if (node == null) return null;
        if (node.getValue() < val) {
            node.setRight(delete(node.getRight(), val));
        }
        if (node.getValue() > val) {
            node.setLeft(delete(node.getLeft(), val));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if ((node.getRight() == null)) {
                return node.getLeft();
            }
            TreeNode suce = getMin(node.getRight());
            node.setValue(suce.getValue());
            node.setRight(delete(node.getRight(), val));
        }
        return node;
    }

    public List<List<Integer>> bfs() {
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
                arr.add(node.getValue());
                if (node.getLeft() != null) queue.add(node.getLeft());
                if (node.getRight() != null) queue.add(node.getRight());
            }
            ++lavel;
            result.add(arr);
        }
        return result;
    }

    private TreeNode getMin(TreeNode right) {
        if (right == null) return null;
        return getMin(right.getLeft());
    }

    private TreeNode getMax(TreeNode left) {
        if (left == null) return null;
        return getMin(left.getRight());
    }

    public TreeNode bstFromArr(int[] arr) {
        if (arr == null) return null;
        return dfs(0, arr.length - 1, arr);
    }

    private TreeNode dfs(int l, int r, int[] arr) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.setLeft(dfs(l, mid - 1, arr));
        node.setRight(dfs(mid + 1, r, arr));
        return node;
    }
}
