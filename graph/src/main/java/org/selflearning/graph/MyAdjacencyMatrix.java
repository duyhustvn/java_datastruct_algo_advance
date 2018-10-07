package org.selflearning.graph;

import java.util.List;
import java.util.ArrayList;;

public class MyAdjacencyMatrix extends MyGraph {
    // implement
    private int[][] adjMatrix;

    public MyAdjacencyMatrix() {
        super();
        adjMatrix = new int[0][0];
    }

    public int getSizeOfMatrix() {
        return this.adjMatrix.length;
    }

    public int[][] getAdjacencyMatrix() {
        return this.adjMatrix;
    }

    public void implementAddEdge(int v, int w) {
        if (v > this.getNumVertices() - 1 || w > this.getNumVertices() - 1) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        adjMatrix[v][w] = 1;
    }

    public void implementAddVertex() {
        int numVertices = this.getNumVertices();

        if (numVertices >= adjMatrix.length) {
            int[][] newAdjMatrix;
            if (numVertices == 0) {
                newAdjMatrix = new int[1][1];
            } else {
                newAdjMatrix = new int[2 * numVertices][2 * numVertices];
            }

            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }

        for (int i = 0; i < adjMatrix[numVertices].length; i++) {
            adjMatrix[numVertices][i] = 0;
        }
    }

    public List<Integer> getNeighbors(int v) {
        // return new ArrayList<>(1);
        List<Integer> neighborList = new ArrayList<Integer>();

        List<Integer> inDegree = this.getInDegree(v);
        List<Integer> outDegree = this.getOutDegree(v);
        if (inDegree.size() != 0) {
            neighborList.addAll(inDegree);
        }

        if (outDegree.size() != 0) {
            neighborList.addAll(outDegree);
        }

        return neighborList;
    };

    public List<Integer> getInDegree(int v) {
        // count in degree
        List<Integer> inDegree = new ArrayList<Integer>();
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[i][v] == 1) {
                inDegree.add(i);
            }
        }
        return inDegree;
    }

    public List<Integer> getOutDegree(int v) {
        // count out degree
        List<Integer> outDegree = new ArrayList<Integer>();

        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[v][i] == 1) {
                outDegree.add(i);
            }
        }
        return outDegree;
    }

    public List<Integer> getDistance2(int v) {
        List<Integer> twoHopsList = new ArrayList<Integer>();

        List<Integer> oneHopsList = this.getOutDegree(v);
        List<Integer> tmpList = new ArrayList<Integer>();
        for (Integer outDegree : oneHopsList) {
            tmpList = this.getOutDegree(outDegree);
            for (Integer a : tmpList) {
                if (twoHopsList.indexOf(a) == -1) {
                    twoHopsList.add(a);
                }
            }
        }

        return twoHopsList;
    }

    public void printGraph() {
        int numVertices = this.getNumVertices();
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}