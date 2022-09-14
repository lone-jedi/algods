package org.yarkin.algods.graph;

import java.util.*;

public class Graph<T> {
    int[][] keys;
    T[] data;

    public Graph(int[][] keys, T[] data) {
        this.keys = keys;
        this.data = data;
    }

    /**
     * @return depth first traversal from root
     */
    List<T> depthFirst() {
        return depthFirst(0);
    }

    List<T> depthFirst(int key) {
        validateKey(key);

        Stack<Integer> keysStack = new Stack<>();
        List<T> result = new ArrayList<>();
        keysStack.push(key);

        while (!keysStack.empty()) {
            int current = keysStack.pop();
            result.add(data[current]);

            for (int i = keys[current].length - 1; i >= 0 ; i--) {
                keysStack.push(keys[current][i]);
            }
        }

        return result;
    }

    /**
     * @return breadth first traversal from root
     */
    List<T> breadthFirst() {
        return breadthFirst(0);
    }

    List<T> breadthFirst(int key) {
        validateKey(key);

        Queue<Integer> keysQueue= new LinkedList<>();
        List<T> result = new ArrayList<>();
        keysQueue.add(key);

        while (!keysQueue.isEmpty()) {
            int current = keysQueue.remove();
            result.add(data[current]);

            for (int i = 0; i < keys[current].length ; i++) {
                keysQueue.add(keys[current][i]);
            }
        }

        return result;
    }

    boolean hasPath(int start, int end) {
        validateKey(start);
        validateKey(end);

        boolean[] history = new boolean[data.length];
        Queue<Integer> keysQueue= new LinkedList<>();
        keysQueue.add(start);

        while (!keysQueue.isEmpty()) {
            int current = keysQueue.remove();
            if (history[current]) {
                continue;
            }

            if (current == end) {
                return true;
            }

            for (int i = 0; i < keys[current].length ; i++) {
                keysQueue.add(keys[current][i]);
            }

            history[current] = true;
        }

        return false;
    }

    private void validateKey(int key) {
        if(key >= 0 && key < data.length) {
            return;
        }

        throw new IllegalArgumentException("The key " + key + " does not exist");
    }
}
