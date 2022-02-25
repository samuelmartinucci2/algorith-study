package com.samuel.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[10000];

        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(100);
        }

        heapSort(arr);

        /* check array is sorted or not */
        System.out.println(Arrays.toString(arr));
        for (int i = 0, limit = arr.length - 1; i < limit; ++i) {
            if (!(arr[i] <= arr[i + 1])) throw new Exception();
        }
    }

    private static void heapSort(int[] arr) {
        int mid = arr.length / 2 + 1;
        // Build max heap
        for (int i = mid; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }

        // Heap Sort
        for (int i = arr.length - 1; i >= 0; i--) {
            // Root is the largest value (max heap built), swap root with the latest element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Exclude the root node moved to the end of the array and heapify.
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int length, int parentPos) {
        int largest = parentPos;
        int leftNode = 2 * parentPos + 1;
        int rightNode = 2 * parentPos + 2;

        if (leftNode < length && arr[leftNode] > arr[largest]) {
            largest = leftNode;
        }
        if (rightNode < length && arr[rightNode] > arr[largest]) {
            largest = rightNode;
        }

        if (largest != parentPos) {
            int temp = arr[parentPos];
            arr[parentPos] = arr[largest];
            arr[largest] = temp;
            heapify(arr, length, largest);
        }
    }
}
