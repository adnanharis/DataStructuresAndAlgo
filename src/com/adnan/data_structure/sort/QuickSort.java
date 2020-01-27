package com.adnan;

import java.util.Date;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int arr[] = new int[100]; // {5, 6, 2, 3, 8, 3, 9, 1}; // 100000000
        Random randomGenerator = new Random();
        long start = new Date().getTime();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomGenerator.nextInt(1000);
        }

        sort(arr, 0, arr.length - 1);

        System.out.println((new Date().getTime() - start));
        printArray(arr);
    }

    private static void sort(int arr[], int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int p = partition(arr, lo, hi);
        sort(arr, lo, p-1);
        sort(arr, p+1, hi);
    }

    private static int partition(int arr[], int lo, int hi) {

        int i = lo, j = hi + 1;
        while (true) {
            while (arr[++i] < arr[lo]) {
                if (i == hi) break;
            }

            while (arr[--j] > arr[lo]) {
                if (j == lo) break;
            }

            if (i >= j) {
                break;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        int temp = arr[lo];
        arr[lo] = arr[j];
        arr[j] = temp;

        return j;
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
