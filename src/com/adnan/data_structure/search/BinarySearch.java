package com.adnan;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int x = 2;
        int y = 11;

        System.out.println("\nElement: " + x + " found: " + binarySearch(arr, x, 0, arr.length - 1));
        System.out.println("\nElement: " + y + " found: " + binarySearch(arr, y, 0, arr.length - 1));
    }

    private static boolean binarySearch(int[] a, int x, int lo, int hi) {
        System.out.print(">> " + lo + " " + hi);
        if (lo > hi) {
            return false;
        }

        int m = lo + (hi - lo) / 2;
        if (a[m] == x) {
            return true;
        }

        if (x < a[m]) {
            return binarySearch(a, x, lo, m - 1);
        } else {
            return binarySearch(a, x, m + 1, hi);
        }
    }
}