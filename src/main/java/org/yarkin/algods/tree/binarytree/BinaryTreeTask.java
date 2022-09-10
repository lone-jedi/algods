package org.yarkin.algods.tree.binarytree;

import org.yarkin.algods.Task;

public class BinaryTreeTask implements Task {
    @Override
    public void run() {
        BinaryTree.Node<Character> root = new BinaryTree.Node<>('a');
        root.left = new BinaryTree.Node<>('b');
        root.right = new BinaryTree.Node<>('c');
        root.left.left = new BinaryTree.Node<>('d');
        root.left.right = new BinaryTree.Node<>('e');
        root.right.right = new BinaryTree.Node<>('f');

        BinaryTree<Character> binaryTree = new BinaryTree<>(root);
        binaryTree.printDepthFirstTraversal();
    }
}