package org.yarkin.algods.tree.binarytree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yarkin.algods.tree.binarytree.BinaryTree.Node;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree<Character> binaryTree;

    /** Binary    a
     *   tree    |  \
     *          b    c
     *         | \    \
     *        d   e    f
     */
    @BeforeEach
    void beforeEach() {
        Node<Character> root = new Node<>('a');
        root.left = new Node<>('b');
        root.right = new Node<>('c');
        root.left.left = new Node<>('d');
        root.left.right = new Node<>('e');
        root.right.right = new Node<>('f');

        binaryTree = new BinaryTree<>(root);
    }

    @Test
    @DisplayName("Depth first traversal test")
    void getDepthFirstTraversal() {
        List<Character> depthFirstTraversal = binaryTree.getDepthFirstTraversal();
        assertEquals(List.of('a', 'b', 'd', 'e', 'c', 'f'), depthFirstTraversal);
    }

    @Test
    @DisplayName("Breadth first traversal test")
    void getBreadthFirstTraversal() {
        List<Character> breadthFirstTraversal = binaryTree.getBreadthFirstTraversal();
        assertEquals(List.of('a', 'b', 'c', 'd', 'e', 'f'), breadthFirstTraversal);
    }

    @Test
    @DisplayName("Search node value in binary tree")
    void searchValueInTree() {
        assertTrue(binaryTree.contains('a'));
        assertTrue(binaryTree.contains('d'));
        assertTrue(binaryTree.contains('f'));

        assertFalse(binaryTree.contains('x'));
    }

    @Test
    @DisplayName("Concatenation of elements from binary tree")
    void treeConcat() {
        assertEquals("abcdef", binaryTree.concat());
    }

    @Test
    void testMaxHeight() {
        assertEquals(3, binaryTree.maxHeight());
    }
}