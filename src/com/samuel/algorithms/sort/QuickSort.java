package com.samuel.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[10000];

        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(100);
        }

        quickSort(arr, 0, arr.length - 1);

        /* check array is sorted or not */
        System.out.println(Arrays.toString(arr));
        for (int i = 0, limit = arr.length - 1; i < limit; ++i) {
            if (!(arr[i] <= arr[i + 1])) throw new Exception();
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }

    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pivotPos = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                int tmp = arr[i];
                arr[i] = arr[pivotPos];
                arr[pivotPos] = tmp;

                pivotPos++;
            }
        }

        int tmp = arr[high];
        arr[high] = arr[pivotPos];
        arr[pivotPos] = tmp;

        return pivotPos;
    }
}
