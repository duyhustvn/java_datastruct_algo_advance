package org.selflearning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximizeArraySum {
    public static Queue<Integer> putToPriorityQueue(int[] arr) {
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        return queue;
    }

    public static int getIndex(int[] arr, int x) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void print(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }
        System.out.println();
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) {
        int [] arr = new int[]{9, 8, 8, 5};
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);

        System.out.println("Enter the number of numbers you wanna change: ");
        int k = 0;
        try {
            k = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Queue<Integer> negativeQueue = putToPriorityQueue(arr);

        for (int i = 0; i < k; i++) {
            int x = negativeQueue.remove();
            System.out.println(x);
            int index = getIndex(arr, x);
            arr[index] = -x;
            negativeQueue.add(-x);
        }

        print(arr);
    }
}
