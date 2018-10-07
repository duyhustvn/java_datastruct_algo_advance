package org.selflearning;

import org.selflearning.graph.MyGraph;
import org.selflearning.graph.MyAdjacencyMatrix;
import org.selflearning.graph.MyAdjacencyList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MyGraph myGraph = new MyAdjacencyList();
        for (int i = 0; i < 10; i++) {
            myGraph.addVertex();
        }

        myGraph.addEdge(0, 1);
        myGraph.addEdge(0, 2);
        myGraph.addEdge(0, 4);
        myGraph.addEdge(2, 4);
        myGraph.addEdge(2, 3);
        // myGraph.addEdge(2, 3);
        myGraph.printGraph();


        System.out.println("Indegree of 3");
        System.out.println( myGraph.getInDegree(3));

        System.out.println("Outdegree of 2");
        System.out.println( myGraph.getOutDegree(2));

        System.out.println("2 hops from 0");
        System.out.println( myGraph.getDistance2(0));
        System.out.println( "Hello World!" );
    }
}
