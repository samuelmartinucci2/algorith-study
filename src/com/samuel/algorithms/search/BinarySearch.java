package com.samuel.algorithms.search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[10000];

        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(10000);
        }

        Arrays.sort(arr);
        int randomPos = random.nextInt(10000);
        System.out.println(String.format("Searching for arr[%d] = %d", randomPos, arr[randomPos]));
        int foundIdx = binarySearch(arr, arr[randomPos], 0, arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.print(String.format("Found arr[%d] = %d", foundIdx, arr[foundIdx]));
    }

    private static int binarySearch(int[] arr, int x, int low, int high) {
        if (high > low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] > x) {
                return binarySearch(arr, x, low, mid - 1);
            }

            return binarySearch(arr, x, mid + 1, high);
        }

        return -1;
    }
}
