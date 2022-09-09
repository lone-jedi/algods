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

    // stack implementation
    List<Character> getDepthFirstTraversal() {
        List<Character> values = new ArrayList<>();
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);

        while (!nodes.empty()) {
            Node current = nodes.pop();
            if (current == null) {
                continue;
            }

            values.add(current.value);
            nodes.push(current.right);
            nodes.push(current.left);
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
            if (current == null) {
                continue;
            }

            result.add(current.value);
            nodes.add(current.left);
            nodes.add(current.right);
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
