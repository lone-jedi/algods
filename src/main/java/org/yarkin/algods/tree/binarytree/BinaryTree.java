package org.yarkin.algods.tree.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    static class Node {
        char value;
        Node right;
        Node left;

        public Node(char value) {
            this.value = value;
        }
    }
}
