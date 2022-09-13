package org.yarkin.algods.tree.binarytree;

public class NumericBinaryTree<T extends Number> extends BinaryTree<T> {
    public NumericBinaryTree(Node<T> root) {
        super(root);
    }

    public double sum() {
        return getBreadthFirstTraversal().stream()
                .mapToDouble(T::doubleValue)
                .sum();
    }

    public double max() {
        return getBreadthFirstTraversal().stream()
                .mapToDouble(T::doubleValue)
                .max()
                .getAsDouble();
    }
}
