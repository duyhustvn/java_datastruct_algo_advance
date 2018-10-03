package org.selflearning;

import org.selflearning.graph.MyGraph;
import org.selflearning.graph.MyAdjacency;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MyGraph myGraph = new MyAdjacency();
        myGraph.printGraph();
        System.out.println( "Hello World!" );
    }
}
