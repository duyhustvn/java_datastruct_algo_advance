package org.selflearning.graph;
import java.util.List;

public abstract class MyGraph {
    private int numVertices;
    private int numEdges;

    public MyGraph() {
        this.numVertices = 0;
        this.numEdges = 0;
    }

    public int getNumVertices() {
        return this.numVertices;
    }

    public int getNumEdges() {
        return this.numEdges;
    }

    public void addVertex() {
        implementAddVertex();
        this.numVertices++;
    }

    public void addEdge(int f, int t) {
        implementAddEdge(f, t);
        this.numEdges++;
    }

    public abstract void implementAddVertex();
    public abstract void implementAddEdge(int f, int t);
    public abstract List<Integer> getNeighbors(int v);
    public abstract void printGraph();
    public abstract List<Integer> getInDegree(int v);
    public abstract List<Integer> getOutDegree(int v);
}