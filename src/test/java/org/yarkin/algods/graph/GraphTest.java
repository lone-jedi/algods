package org.yarkin.algods.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    /**
     *            a
     *          | |  \
     *         b  c <- d
     *        |        \
     *        f  --->   e
     */
    private Graph<Character> graph;

    @BeforeEach
    void before() {
        int[][] keys =   {{1, 2, 3}, {5},  {}, {2, 4}, {}, {4}};
        Character[] values = {'a',   'b', 'c', 'd',   'e', 'f'};
        //                     0      1    2    3      4    5
        graph = new Graph<>(keys, values);
    }

    @Test
    @DisplayName("Get graph values by depth first algorithm")
    void depthFirstTest() {
        assertEquals(List.of('a', 'b', 'f', 'e', 'c', 'd', 'c', 'e'), graph.depthFirst());
    }

    @Test
    @DisplayName("Get graph values by breadth first algorithm")
    void breadthFirstTest() {
        assertEquals(List.of('a', 'b', 'c', 'd', 'f', 'c', 'e', 'e'), graph.breadthFirst());
    }

    @Test
    @DisplayName("Has path between two nodes")
    void hasPathTest() {
        assertTrue(graph.hasPath(0, 5));
        assertTrue(graph.hasPath(0, 4));
        assertTrue(graph.hasPath(0, 3));
        assertTrue(graph.hasPath(0, 2));
        assertTrue(graph.hasPath(0, 1));
        assertTrue(graph.hasPath(0, 0));

        assertTrue(graph.hasPath(1, 4));
    }

    @Test
    @DisplayName("Does not have path between two nodes")
    void hasNoPathTest() {
        assertFalse(graph.hasPath(1, 2));
        assertFalse(graph.hasPath(3, 0));
    }

    @Test
    @DisplayName("Has path, but loop exists")
    void hasLoopPathTest() {
        //    d  - e
        //    |
        //    a
        //    |  \
        //    b -  c
        int[][] keys =   {{1, 2, 3}, {0, 2}, {0, 1},   {4, 0},  {} };
        Character[] values = {'a',    'b',      'c',     'd',   'e'};
        //                     0       1         2        3      4
        Graph<Character> loopGraph = new Graph<>(keys, values);

        assertTrue(loopGraph.hasPath(0, 4));
    }
}