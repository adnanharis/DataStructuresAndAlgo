package com.adnan;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 2, 3, 8, 3, 9, 1};

        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);

        printArray(arr);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int i = lo, j = mid + 1, k = lo;

        while (k <= hi) {

            if (j > hi) {
                a[k++] = aux[i++];
            } else if (i > mid) {
                a[k++] = aux[j++];
            } else if (aux[i] < aux[j]) {
                a[k++] = aux[i++];
            } else {
                a[k++] = aux[j++];
            }
        }

    }


    private static void mergeSort(int[] arr, int[] aux, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, aux, lo, mid);
        mergeSort(arr, aux, mid + 1, hi);

        merge(arr, aux, lo, mid, hi);

    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
