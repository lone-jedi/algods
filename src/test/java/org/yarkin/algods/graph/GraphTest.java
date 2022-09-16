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

    /**
     *   d  - e
     *   |
     *   a
     *   | \
     *   b -  c
     */
    private Graph<Character> loopGraph;

    /**
     *   d  - e
     *
     *   a    f
     *   | \
     *   b -  c
     */
    private Graph<Character> multipleComponentsGraph;

    /**
     *   d  - e
     *
     *   a    f
     *   | \
     *   b -  c
     */
    private Graph<Character> undirectionalMultipleComponentsGraph;

    @BeforeEach
    void before() {
        graph = new Graph<>(
                new int[][] {{1, 2, 3}, {5},  {}, {2, 4}, {}, {4}},
                new Character[] {'a',   'b', 'c', 'd',   'e', 'f'});

        loopGraph = new Graph<>(
                new int[][] {{1, 2, 3}, {0, 2}, {0, 1},   {4, 0},  {} },
                new Character[] {'a',    'b',      'c',     'd',   'e'});

        multipleComponentsGraph = new Graph<>(
                new int[][] {  {1, 2}, {0, 2}, {0, 1}, {4}, {},  {}},
                new Character[] {'a',    'b',    'c',  'd', 'e', 'f'});

        undirectionalMultipleComponentsGraph = new Graph<>(
                new int[][] {  {1, 2}, {0, 2}, {0, 1}, {4}, {3},  {}},
                new Character[] {'a',    'b',    'c',  'd', 'e', 'f'});
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
    @DisplayName("Get graph only unique values by breadth first algorithm")
    void breadthFirstUniqueTest() {
        assertEquals(List.of('a', 'b', 'c', 'd', 'f', 'e'), graph.breadthFirstUnique());
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
        assertTrue(loopGraph.hasPath(0, 4));
    }


    @Test
    @DisplayName("Get number of connected components")
    void connectedComponentsCountTest() {
        Graph<Character> newGraph = new Graph<>(
                new int[][] {{8, 1, 5}, {0}, {3, 4}, {}, {3, 2}, {0, 8}, {}, {}, {0, 5}},
                new Character[] {}
        );

       //  assertEquals(2, newGraph.connectedComponentsCount());
        assertEquals(3, undirectionalMultipleComponentsGraph.connectedComponentsCount());
        assertEquals(1, graph.connectedComponentsCount());
        assertEquals(0, new Graph<>(new int[][] {}, new Character[] {}));
        assertEquals(0, new Graph<>(null, null));
    }

    @Test
    @DisplayName("Get largest component from graph")
    void getLargestComponentTest() {
        assertEquals(3, undirectionalMultipleComponentsGraph.getLargestComponent());
        assertEquals(3, multipleComponentsGraph.getLargestComponent());
        assertEquals(5, loopGraph.getLargestComponent());
        assertEquals(6, graph.getLargestComponent());
    }
}