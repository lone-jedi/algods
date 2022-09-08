package org.yarkin.algods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yarkin.algods.tree.binarytree.BinaryTreeTask;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class TaskFactoryTest {

    @Test
    @DisplayName("Get instance method returns proper class")
    void getInstanceTest() {
        Task task = TaskFactory.getInstance("btree");
        assertInstanceOf(BinaryTreeTask.class, task);
    }
}