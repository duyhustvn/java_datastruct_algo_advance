import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort2 {

    public int[] readFile(File file) {
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            return new int[]{-1};
        }
        
        // int arCount = Integer.parseInt(sc.nextLine().trim());

        String[] arrStr = sc.nextLine().split(" ");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            int arrItem = Integer.parseInt(arrStr[i].trim());
            arr[i] = arrItem;
        }
        sc.close();
        return arr;
    }

    public void mergeSort(int[] arr) {
        int length = arr.length;
        if (length > 1) {
            int mid = length / 2;
            int[] arrL = new int[mid];
            System.arraycopy(arr, 0, arrL, 0, mid);
            int[] arrR = new int[arr.length - mid];
            System.arraycopy(arr, mid, arrR, 0, arr.length - mid);
            mergeSort(arrL);
            mergeSort(arrR);
            merge(arr, arrL, arrR);
        }
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void merge(int[] mergeArr, int[] arrL, int[] arrR) {
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < arrL.length && j < arrR.length) {
            if (arrL[i] < arrR[j]) {
                mergeArr[k] = arrL[i];
                i++;
                k++;
            } else {
                mergeArr[k] = arrR[j];
                j++;
                k++;
            }
        }
        while (i < arrL.length) {
            mergeArr[k] = arrL[i];
            i++;
            k++;
        }

        while (j < arrR.length) {
            mergeArr[k] = arrR[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {

        MergeSort2 mergeSort = new MergeSort2();

        File file = new File("data.txt");
        int[] arr = mergeSort.readFile(file);
        mergeSort.mergeSort(arr);
        mergeSort.printArray(arr);

    }
}