package binar;

import binar.tree.BinaryTree;
import binar.tree.Order;

import java.util.List;

public class Executor {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(6);
        binaryTree.insert(3);
        binaryTree.insert(8);
        List<Integer> order = binaryTree.order(Order.IN);
        System.out.println(order);
        List<List<Integer>> bfs = binaryTree.bfs();
        System.out.println(bfs);
    }
}
