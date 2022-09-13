package org.yarkin.algods.tree.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.yarkin.algods.tree.binarytree.NumericBinaryTree.Node;
import static org.junit.jupiter.api.Assertions.*;

class NumericBinaryTreeTest {
    private NumericBinaryTree numericBinaryTree;

    /** Binary    0
     *   tree    |  \
     *          1    2
     *         | \    \
     *        3   4    5
     */
    @BeforeEach
    void beforeEach() {
        Node<Integer> root = new Node<>(0);
        root.left = new Node<>(1);
        root.right = new Node<>(2);
        root.left.left = new Node<>(3);
        root.left.right = new Node<>(4);
        root.right.right = new Node<>(5);

        numericBinaryTree = new NumericBinaryTree(root);
    }

    @Test
    @DisplayName("Sum of tree numeric values")
    void sumTest() {
        assertEquals(15, numericBinaryTree.sum());
    }

    @Test
    @DisplayName("Max node value of tree")
    void getMaxValue() {
        assertEquals(5, numericBinaryTree.max());
    }
}