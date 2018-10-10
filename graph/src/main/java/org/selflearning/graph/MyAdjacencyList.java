package org.selflearning.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdjacencyList extends MyGraph {
    private Map<Integer, ArrayList<Integer>> adjacencyList;

    public MyAdjacencyList() {
        super();
        adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
    }

    public Map<Integer, ArrayList<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void implementAddVertex() {
        int numVertices = adjacencyList.size();
        adjacencyList.put(numVertices, new ArrayList<Integer>());
    }

    public void implementAddEdge(int v, int w) {
        if (v > this.getNumVertices() - 1 || w > this.getNumVertices() - 1 || v < 0 || w < 0) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        if (this.adjacencyList.get(v).indexOf(w) == -1) {
            this.adjacencyList.get(v).add(w);
        }
    }

    public List<Integer> getNeighbors(int v) {
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
    }

    public List<Integer> getInDegree(int v) {
        if (v < 0 || v > this.getNumVertices() -1 ) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }
        List<Integer> indegreeList = new ArrayList<Integer>();
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (adjacencyList.get(i).indexOf(v) != -1) {
                indegreeList.add(i);
            }
        }
        return indegreeList;
    }

    public List<Integer> getOutDegree(int v) {
        if (v < 0 || v > this.getNumVertices() -1 ) {
            throw new IndexOutOfBoundsException("Index out of bound");
        }

        // List<Integer> outDegreeList = adjacencyList.get(v);
        List<Integer> outDegreeList = new ArrayList<Integer>(adjacencyList.get(v));


        return outDegreeList;
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
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println(i + "-> {" + adjacencyList.get(i) + "}");
        }
    }
}