package org.yarkin.algods.graph;

import java.util.*;

public class Graph<T> {
    private static final int ROOT_KEY = 0;
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
        return depthFirst(ROOT_KEY);
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
        return breadthFirst(ROOT_KEY);
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

    /**
     * @return breadth first traversal only unique values from root
     */
    List<T> breadthFirstUnique() {
        boolean[] visited = new boolean[keys.length];
        return breadthFirstUnique(0, visited);
    }

    List<T> breadthFirstUnique(int key) {
        boolean[] visited = new boolean[keys.length];
        return breadthFirstUnique(key, visited);
    }

    List<T> breadthFirstUnique(int key, boolean[] visited) {
        validateKey(key);

        Queue<Integer> keysQueue= new LinkedList<>();
        List<T> result = new ArrayList<>();

        keysQueue.add(key);

        while (!keysQueue.isEmpty()) {
            int current = keysQueue.remove();

            if (visited[current]) {
                continue;
            }

            visited[current] = true;

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

    /**
     * DOES NOT WORK YET
     *
     * @return connected graph nodes count
     */
    int connectedComponentsCount() {
        int count = 0;
        boolean[] visited = new boolean[keys.length];
        for (int i = 0; i < keys.length; i++) {
            if (explore(i, visited)) {
                count++;
            }
        }

        return count;
    }

    public int getLargestComponent() {
        boolean[] visited = new boolean[keys.length];
        int maxCount = 0;

        for (int i = 0; i < keys.length; i++) {
            if (visited[i]) {
                continue;
            }

            int size = breadthFirstUnique(i, visited).size();

            if(size > maxCount) {
                maxCount = size;
            }
        }

        return maxCount;
    }

    /**
     * Get the shortest path to the element from root to target
     *
     * @param target key of a target node
     * @return subgraph which contains the shortest path from start to the target node
     */
    public Graph<T> getShortestPath(int target) {
        return getShortestPath(ROOT_KEY, target);
    }

    /**
     * Get the shortest path to the element from start to target
     *
     * @param start key of a start node
     * @param target key of a target node
     * @return subgraph which contains the shortest path from start to the target node
     */
    public Graph<T> getShortestPath(int start, int target) {
        return null;
    }

    private boolean explore(int current, boolean[] visited) {
        if (visited[current]) {
            return false;
        }

        visited[current] = true;

        for (int i = 0; i < keys[current].length; i++) {
            explore(i, visited);
        }

        return true;
    }

    private void validateKey(int key) {
        if(key >= 0 && key < data.length) {
            return;
        }

        throw new IllegalArgumentException("The key " + key + " does not exist");
    }


}
