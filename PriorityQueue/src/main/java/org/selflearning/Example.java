package org.selflearning;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Example {
    public void print(PriorityQueue priorityQueue) {
        // print all element
        Iterator<String> itr = priorityQueue.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        Example example = new Example();
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();

        priorityQueue.add("C");
        priorityQueue.add("R");
        priorityQueue.add("Php");
        priorityQueue.add("Java");
        priorityQueue.add("Python");

        // most priority element
        System.out.println("Headvalue using peek function: " + priorityQueue.peek());

        System.out.println("The queue element: ");
        example.print(priorityQueue);

        // removing top priority element
        priorityQueue.poll();
        System.out.println("After remove an element with poll function");
        example.print(priorityQueue);

        // remove java
        priorityQueue.remove("Java");
        System.out.println("After remove java");
        example.print(priorityQueue);

    }
}
