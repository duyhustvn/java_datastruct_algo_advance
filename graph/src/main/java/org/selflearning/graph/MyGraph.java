package org.selflearning.graph;
import java.util.*;

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

    /* Algorithm
    Next node: Queue
    Visited set: HashSet
    parent: HashMap

    Add start to Queue and visited set
    while Queue is not empty 
        dequeu start from queue as current node
        if current == end return parent map
        foreach current neighbor node, n, not in visited n
            add n to visted set
            add current node as n's parent in parent map
            enqueue n to queue
    */
    public HashMap<Integer, Integer> BFS( int start, int end) {
        Queue<Integer> nextNode = new LinkedList<Integer>();
        HashSet<Integer> visited = new HashSet<Integer>();
        HashMap<Integer, Integer> parent = new HashMap<Integer, Integer>();
        nextNode.add(start);
        visited.add(start);
        Integer current;
        while (nextNode.size() != 0) {
            current = nextNode.remove();
            if (current == end) {
                return parent;
            }
            List<Integer> neighbors = this.getOutDegree(current);
            for (Integer neighbor: neighbors) {
                visited.add(neighbor);
                parent.put(current, neighbor);
                nextNode.add(neighbor);
            }
        }
    }   

    public abstract void implementAddVertex();
    public abstract void implementAddEdge(int f, int t);
    public abstract List<Integer> getNeighbors(int v);
    public abstract void printGraph();
    public abstract List<Integer> getInDegree(int v);
    public abstract List<Integer> getOutDegree(int v);
    public abstract List<Integer> getDistance2(int v);
}