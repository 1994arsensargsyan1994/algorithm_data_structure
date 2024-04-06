package avl;

public class AVLTree {

    private Node root;
    private int size;

    private Node rightRotate(Node z) {
        Node y = z.getLeft();
        Node T3 = y.getRight();
        y.setRight(z);
        z.setLeft(T3);
        return y;
    }

    private Node leftRotate(Node z) {
        Node y = z.getRight();
        Node T2 = y.getLeft();
        y.setLeft(z);
        z.setRight(T2);
        return y;
    }

    void insert(int key) {
        this.root = insert(this.root, key);
        size++;
    }

    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key > node.getValue()) {
            node.setRight(insert(node.getRight(), key));
        } else {
            node.setLeft(insert(node.getLeft(), key));
        }

        int bf = getBf(node);

        if (bf > 1 && key < node.getLeft().getValue()) {
            return rightRotate(node);
        }
        if (bf > 1 && key > node.getLeft().getValue()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if (bf < -1 && key > node.getRight().getValue()) {
            return leftRotate(node);
        }
        if (bf < -1 && key < node.getRight().getValue()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        } else return node;
    }

    private int getBf(Node node) {
        if (node == null) return 0;
        return height(node.getLeft()) - height(node.getRight());
    }

    private int height(Node node) {
        if (node == null) return -1;
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
