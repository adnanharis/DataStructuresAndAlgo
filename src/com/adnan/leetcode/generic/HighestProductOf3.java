// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/python/highest-product-of-3?course=fc1&section=greedy

public class HighestProductOf3 {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] list1 = new int[]{10, 10, 1, 3, 2};
        int[] list2 = new int[]{-10, -10, 1, 3, 2};
        System.out.println(highestProductOfThree(list2));
    }

    private static long highestProductOfThree(int[] data) {
        if (data.length < 3) {
            throw new IllegalArgumentException("Array does not contains expected number of elements");
        }

        int[] result = new int[3];
        result[0] = Integer.MIN_VALUE;
        result[1] = Integer.MIN_VALUE;
        result[2] = Integer.MIN_VALUE;

        for (int i = 0; i < data.length; i++) {
            checkAndchoose(result, data[i]);
        }

        return result[0] * result[1] * result[2];
    }

    private static void checkAndchoose(int[] data, int x) {
        x = Math.abs(x); // Ignoring the sign
        for (int i = 0; i < data.length; i++) {
            if (data[i] < x) {
                int t = data[i];
                data[i] = x;
                x = t;
            }
        }
        // We can improve above loop by travesing in reverse and break immidiately if element is lesser.
    }
}