package org.yarkin.algods;

import org.yarkin.algods.graph.GraphTask;
import org.yarkin.algods.tree.binarytree.BinaryTreeTask;

import java.util.Locale;

public class TaskFactory {
    public static Task getInstance(String taskName) {
        switch (taskName.toUpperCase(Locale.ROOT))
        {
            case "BTREE":
                return new BinaryTreeTask();
            case "GRAPH":
                return new GraphTask();
        }

        throw new IllegalArgumentException("Task \"" + taskName + "\" does not exist");
    }
}
