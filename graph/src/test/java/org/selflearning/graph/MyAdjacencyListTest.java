package org.selflearning.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyAdjacencyListTest {
    MyAdjacencyList adjacencyList;

    @Before
    public void setUp() {
        adjacencyList = new MyAdjacencyList();
        for (int i = 0; i < 5; i++) {
            adjacencyList.addVertex();
        }
    }

    @Test
    public void testAddVertex() {
        adjacencyList.addVertex();
        System.out.println(adjacencyList.getAdjacencyList().get(0));
        assertEquals("Test add vertex there is one vertex", 6, adjacencyList.getNumVertices());
    }

    @Test
    public void testAddEdge() {
        adjacencyList.addEdge(0, 2);
        adjacencyList.addEdge(0, 2);
        System.out.println(adjacencyList.getAdjacencyList());
        assertEquals("Test add edge ", Integer.valueOf(2), adjacencyList.getAdjacencyList().get(0).get(0));
        assertEquals("Test add edge not adding existing edge", 1, adjacencyList.getAdjacencyList().get(0).size());


        try {
            adjacencyList.addEdge(5, 4);
            fail("Index out of bound");
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            adjacencyList.addEdge(4, 5);
            fail("Index out of bound");
        } catch (IndexOutOfBoundsException e) {

        }
    }

    @Test
    public void testGetIndegree() {
        assertEquals("Test get indegree size is 0", 0, adjacencyList.getInDegree(3).size());

        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(1, 3);
        assertEquals("Test get indegree size is 2", 2, adjacencyList.getInDegree(3).size());
    }
}