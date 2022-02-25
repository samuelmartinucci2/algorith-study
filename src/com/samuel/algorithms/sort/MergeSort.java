package com.samuel.algorithms.sort;

import java.util.Random;

public class MergeSort {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[100];

        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(100);
        }

        mergeSort(arr, 0, arr.length - 1);

        /* check array is sorted or not */
        for (int i = 0, limit = arr.length - 1; i < limit; ++i) {
            if (!(arr[i] <= arr[i + 1])) throw new Exception();
        }
    }


    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int subarray1Length = m - l + 1;
        int subarray2Lengthn = r - m;

        int[] L = new int[subarray1Length];
        int[] R = new int[subarray2Lengthn];
        // L ← A[l..m]
        System.arraycopy(arr, l, L, 0, subarray1Length);
        // R ← A[m+1..r]
        System.arraycopy(arr, m + 1, R, 0, subarray2Lengthn);

        int i, j, k;
        i = 0;
        j = 0;
        k = l;
        while (i < subarray1Length && j < subarray2Lengthn) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < subarray1Length) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < subarray2Lengthn) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
