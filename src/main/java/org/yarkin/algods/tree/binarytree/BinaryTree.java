package org.yarkin.algods.tree.binarytree;

import java.util.*;

public class BinaryTree<T> {
    private final Node<T> root;

    BinaryTree(Node<T> root) {
        this.root = root;
    }

    public void printDepthFirstTraversal() {
        List<T> depthFirstTraversal = getDepthFirstTraversal();
        System.out.println(depthFirstTraversal);
    }

    public void printBreadthFirstTraversal() {
        List<T> breadthFirstTraversal = getBreadthFirstTraversal();
        System.out.println(breadthFirstTraversal);
    }

    public boolean contains(T value) {
        return getBreadthFirstTraversal().contains(value);
    }

    public String concat() {
        StringBuilder stringBuilder = new StringBuilder();
        getBreadthFirstTraversal().forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    // stack implementation
    List<T> getDepthFirstTraversal() {
        List<T> values = new ArrayList<>();
        Stack<Node<T>> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.empty()) {
            Node<T> current = nodes.pop();
            values.add(current.value);

            if (current.right != null) {
                nodes.push(current.right);
            }
            if (current.left != null) {
                nodes.push(current.left);
            }
        }

        return values;
    }

    // queue based algorithm
    List<T> getBreadthFirstTraversal() {
        List<T> result = new ArrayList<>();
        Queue<Node<T>> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node<T> current = nodes.remove();

            result.add(current.value);
            if (current.left != null) {
                nodes.add(current.left);
            }
            if (current.right != null) {
                nodes.add(current.right);
            }
        }

        return result;
    }

    static class Node<T> {
        T value;
        Node<T> right;
        Node<T> left;

        public Node(T value) {
            this.value = value;
        }
    }
}
