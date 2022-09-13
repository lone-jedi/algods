package org.yarkin.algods.graph;

import org.yarkin.algods.Task;

public class GraphTask implements Task {
    @Override
    public void run() {
        /**
         *            a
         *          | |  \
         *         b  c <- d
         *                \
         *                 e
         */
        int[][] keys = {{1, 2, 3}, {}, {}, {2, 4}, {}};
        Character[] values = {'a', 'b', 'c', 'd', 'e'};

        Graph<Character> graph = new Graph<>(keys, values);

    }
}
