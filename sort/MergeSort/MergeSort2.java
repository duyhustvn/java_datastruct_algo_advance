public class MergeSort2 {
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
                mergeArr[k] = arrL[j];
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
        int[] arr = new int[] { 1, 3, 4, 3, 5, 23, 1, 232 };
        MergeSort2 mergeSort = new MergeSort2();

        mergeSort.mergeSort(arr);
        mergeSort.printArray(arr);
    }
}