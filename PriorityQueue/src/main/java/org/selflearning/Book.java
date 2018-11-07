package org.selflearning;

import java.util.PriorityQueue;
import java.util.Queue;

public class Book implements Comparable<Book> {
    private int id;
    private String name, author;
    private int quantity;

    public Book(int id, String name, String author, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }

    public int compareTo(Book o) {
        return (this.id - o.id);
    }

    public String toString() {
        return "Book id: " + id + " name: " + name;
    }

    public static void print(Queue<Book> queue) {
        for (Book b: queue) {
            System.out.println(b.toString());
        }
    }

    public static void main(String[] args) {
        Queue<Book> queue = new PriorityQueue<Book>();

        Book b1 = new Book(123, "Cô giáo thảo", "Đéo biết", 21);
        Book b2 = new Book(321, "Chú kim", "Đéo biết", 212);
        Book b3 = new Book(100, "Anh hàng xóm tốt bụng", "Đéo biết", 12);
        Book b4 = new Book(123, "Bác đưa thư vui tính", "Đéo biết", 34);

        queue.add(b1);
        queue.add(b2);
        queue.add(b3);
        queue.add(b4);

        print(queue);

        System.out.println("After peek");
        queue.peek();
        print(queue);

        System.out.println("After poll");
        queue.poll();
        print(queue);
    }
}
