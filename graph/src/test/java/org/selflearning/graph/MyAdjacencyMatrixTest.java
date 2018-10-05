package org.selflearning.graph;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MyAdjacencyMatrixTest {
    MyAdjacencyMatrix adjacencyGraph;
    @Before
    public void setUp() throws Exception {
        adjacencyGraph = new MyAdjacencyMatrix();
        for (int i = 0; i < 6; i++) {
            adjacencyGraph.addVertex();
        }

        adjacencyGraph.addEdge(0, 1);
        adjacencyGraph.addEdge(0, 3);
        adjacencyGraph.addEdge(2, 0);
        adjacencyGraph.addEdge(4, 0);
    }

    @Test 
    public void testAddVertex() {
        assertEquals("Testing method addVertex", 8, adjacencyGraph.getSizeOfMatrix());
    }

    @Test
    public void testAddEdge() {
        assertEquals("Testing add edge there is a adge from 0 to 1", 1, adjacencyGraph.getAdjacencyMatrix()[0][1]);
    }

    @Test
    public void testGetInDegree() {
        assertEquals("Test get in degree there is 2 in degree from vertex 0", 2, adjacencyGraph.getInDegree(0).size());
    }
}
