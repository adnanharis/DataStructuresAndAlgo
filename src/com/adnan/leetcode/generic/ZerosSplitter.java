/*
  Given an array of 0s and other ints.
  Separate the array into 0s and other ints with 0s first.
  :: Should be inplce with O(n) time and O(1) space.
*/

public class ZerosSplitter {
    private static int COUNT = 0;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] data = new int[]{1, 0, 2, 0, 3, 0, 4};
        split(data);
        System.out.println(Arrays.toString(data));
        System.out.println("Complexity: O(" + COUNT + ")");
    }

    private static void split(int[] data) {
        int i = 0, j = 0, t;
        while (i < data.length && j < data.length) {
            COUNT++;
            if (data[i] == 0) {
                i++;
            }

            if (data[j] == 0) {
                t = data[i];
                data[i] = data[j];
                data[j] = t;
            }
            j++;
        }
    }
}