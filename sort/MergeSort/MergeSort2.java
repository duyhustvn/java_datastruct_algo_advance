import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort2 {

    // public int countLine(File file) {
    //     LineNumberReader reader = null;
    //     int numberOfLine = 0;
    //     try {
    //         reader = new LineNumberReader(new FileReader(file));
    //         while (reader.readLine() != null)
    //             ;
    //         numberOfLine = reader.getLineNumber();
    //         System.out.println("Count of lines " + reader.getLineNumber());

    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     } finally {
    //         if (reader != null) {
    //             try {
    //                 reader.close();
    //             } catch (IOException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    //     return numberOfLine;
    // }

    public void readFile(ArrayList<Integer> arr ,File file) {
        Scanner sc;
        try {
            sc = new Scanner(file);
            while (sc.hasNext()) {
                int number = sc.nextInt();
                arr.add(number);
            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void mergeSort(ArrayList<Integer> arr) {
        int length = arr.size();
        if (length > 1) {
            int mid = length / 2;
            ArrayList<Integer> arrL = new ArrayList<Integer>(mid);
            // System.arraycopy(arr, 0, arrL, 0, mid);
            for (int i = 0; i < mid; i++) {
                arrL.add(arr.get(i));
            }
            ArrayList<Integer> arrR = new ArrayList<Integer>(arr.size() - mid);
            // System.arraycopy(arr, mid, arrR, 0, arr.size() - mid);
            for (int i = mid; i < arr.size(); i++) {
                arrR.add(arr.get(i));
            }
            mergeSort(arrL);
            mergeSort(arrR);
            merge(arr, arrL, arrR);
        }
    }

    public void printArray(ArrayList<Integer> arr) {
        for (Integer number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public void merge(ArrayList<Integer> mergeArr, ArrayList<Integer> arrL, ArrayList<Integer> arrR) {
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < arrL.size() && j < arrR.size()) {
            if (arrL.get(i) < arrR.get(j)) {
                mergeArr.set(k, arrL.get(i));
                i++;
                k++;
            } else {
                mergeArr.set(k, arrR.get(j));
                j++;
                k++;
            }
        }
        while (i < arrL.size()) {
            mergeArr.set(k, arrL.get(i));
            i++;
            k++;
        }

        while (j < arrR.size()) {
            mergeArr.set(k, arrR.get(j));
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        MergeSort2 mergeSort = new MergeSort2();

        File file = new File("/home/ledinhduy/developer/java_datastruct/sort/MergeSort/data.txt");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        mergeSort.readFile(arr, file);
        long startTime = System.nanoTime();
        mergeSort.mergeSort(arr);
        long endTime = System.nanoTime();
        double estimateTime = (endTime - startTime) / 100000000.0;
        // mergeSort.printArray(arr);
        // mergeSort.countLine(file);
        System.out.println("Number of data: " + arr.size());
        System.out.println("Mersort time: " + estimateTime);
    }
}