package org.yarkin.algods.tree.binarytree;

import org.yarkin.algods.Task;

public class BinaryTreeTask implements Task {
    @Override
    public void run() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.printDepthFirstTraversal();
    }
}