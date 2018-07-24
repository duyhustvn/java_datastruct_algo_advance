package com.company;

public class MergeSort {
    public int[] mergeSort(int[] array, int l, int r) {
        // best case: length of array is 1
        if (l > r)  {
            System.out.println("something went wrong");
        }

        if (l < r) {
            int mid = (l + r) / 2;
            int[] arrLeft = new int[mid+1];
            System.arraycopy(array, 0, arrLeft, 0, mid);
            mergeSort(arrLeft, l, mid);


            if (array.length % 2 == 0) {
                int[] arrRight = new int[array.length - mid ];
            }

            int[] arrRight = new int[array.length - mid];
            System.arraycopy(array, 0, arrRight, 0, array.length - mid );
            mergeSort(arrRight, mid + 1, r);
        }

        if (l == r) {

        }
    }
}
