package com.samuel.algorithms.sort;

import java.util.*;

public class BucketSort {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[1000000];

        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(100) - 50;
        }

        bucketSort(arr);

        /* check array is sorted or not */
        for (int i = 0, limit = arr.length - 1; i < limit; ++i) {
            if (!(arr[i] <= arr[i + 1])) throw new Exception();
        }
    }

    private static void bucketSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int numberOfBuckets = max - min + 1;

        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
        for (int i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (int elem: arr) {
            int hash = (elem - min) / numberOfBuckets;
            buckets.get(hash).add(elem);
        }

        for (List<Integer> bucket: buckets) {
            Collections.sort(bucket);
        }

        int idx = 0;
        for (List<Integer> bucket : buckets) {
            for (int elem : bucket) {
                arr[idx++] = elem;
            }
        }
    }


}
