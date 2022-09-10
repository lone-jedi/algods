package org.yarkin.algods.tree.binarytree;

import java.util.*;

public class BinaryTree {
    private Node root;

    /**           a
     *           |  \
     *          b    c
     *         | \    \
     *        d   e    f
     */
    public BinaryTree() {
        root = new Node('a');
        root.left = new Node('b');
        root.right = new Node('c');
        root.left.left = new Node('d');
        root.left.right = new Node('e');
        root.right.right = new Node('f');
    }

    BinaryTree(Node root) {
        this.root = root;
    }

    public void printDepthFirstTraversal() {
        List<Character> depthFirstTraversal = getDepthFirstTraversal();
        System.out.println(depthFirstTraversal);
    }

    public void printBreadthFirstTraversal() {
        List<Character> breadthFirstTraversal = getBreadthFirstTraversal();
        System.out.println(breadthFirstTraversal);
    }

    public boolean contains(char value) {
        return getBreadthFirstTraversal().contains(value);
    }

    public String concat() {
        StringBuilder stringBuilder = new StringBuilder();
        getBreadthFirstTraversal().stream()
                .forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    // stack implementation
    List<Character> getDepthFirstTraversal() {
        List<Character> values = new ArrayList<>();
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.empty()) {
            Node current = nodes.pop();
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
    List<Character> getBreadthFirstTraversal() {
        List<Character> result = new ArrayList<>();
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node current = nodes.remove();

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

    static class Node {
        char value;
        Node right;
        Node left;

        public Node(char value) {
            this.value = value;
        }
    }
}
