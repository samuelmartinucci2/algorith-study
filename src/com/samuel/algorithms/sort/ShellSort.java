package com.samuel.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[10000];

        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(100);
        }

        shellSort(arr);

        /* check array is sorted or not */
        System.out.println(Arrays.toString(arr));
        for (int i = 0, limit = arr.length - 1; i < limit; ++i) {
            if (!(arr[i] <= arr[i + 1])) throw new Exception();
        }
    }

    private static void shellSort(int[] arr) {
        int arrayLength = arr.length;
        for (int interval = arrayLength / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < arrayLength; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= interval && arr[j - interval] > temp) {
                    arr[j] = arr[j-interval];
                    j -= interval;
                }

                arr[j] = temp;
            }
        }
    }
}
