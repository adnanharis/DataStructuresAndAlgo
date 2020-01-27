// "static void main" must be defined in a public class.
// Write a method to merge sorted arrays into one sorted array.
public class MergeSortedArray {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 10, 12, 14, 19};

        System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
        // prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n = arr1.length + arr2.length;
        int[] mergedArr = new int[n];

        // We can save the space for k by adding i and j ie k = i + j
        while (k < n) {
            if (i == arr1.length) {
                mergedArr[k++] = arr2[j++];
            } else if (j == arr2.length) {
                mergedArr[k++] = arr1[i++];
            } else if (arr1[i] <= arr2[j]) {
                mergedArr[k++] = arr1[i++];
            } else {
                mergedArr[k++] = arr2[j++];
            }
        }

        return mergedArr;
    }
}