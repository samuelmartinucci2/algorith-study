package com.samuel.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[1000000];

        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(100);
        }

        countingSort(arr);

        /* check array is sorted or not */
        for (int i = 0, limit = arr.length - 1; i < limit; ++i) {
            if (!(arr[i] <= arr[i + 1])) throw new Exception();
        }
    }

    private static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int count[] = new int[max + 1];
        int output[] = new int[arr.length];
        for (int elem: arr) {
            count[elem]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
