package com.samuel.algorithms.sort;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[1000];

        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(100) - 50;
        }

        bubbleSort(arr);

        /* check array is sorted or not */
        for (int i = 0, limit = arr.length - 1; i < limit; ++i) {
            if (!(arr[i] <= arr[i + 1])) throw new Exception();
        }
    }

    private static void bubbleSort(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                    swapped = true;
                }
            }

            if (!swapped) return;
        }
    }
}
