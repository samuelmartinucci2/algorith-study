package com.samuel.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[10000];

        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(100);
        }

        selectionSort(arr);

        /* check array is sorted or not */
        System.out.println(Arrays.toString(arr));
        for (int i = 0, limit = arr.length - 1; i < limit; ++i) {
            if (!(arr[i] <= arr[i + 1])) throw new Exception();
        }
    }

    private static void selectionSort(int[] arr) {
        for (int step = 0; step < arr.length; step++) {
            int minimumIdx = step;
            for (int i = step + 1; i < arr.length; i++) {
                if (arr[minimumIdx] > arr[i]) {
                    minimumIdx = i;
                }
            }

            int temp = arr[step];
            arr[step] = arr[minimumIdx];
            arr[minimumIdx] = temp;
        }
    }
}
