// "static void main" must be defined in a public class.
// Beast: https://www.interviewcake.com/question/find-duplicate-optimize-for-space-beast-mode
// Normal: https://www.interviewcake.com/question/python/find-duplicate-optimize-for-space?course=fc1&section=sorting-searching-logarithms
// Can be done by sorting the list O(nLgn)

public class FindDuplicateBEAST {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // numbers from 1..n
        int[] list = new int[]{3, 1, 3, 2};

        int d = findDuplicateBeast(list);
        System.out.println(d + " " + Arrays.toString(list));
    }

    private static int findDuplicateBeast(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int pos = Math.abs(data[i]);
            if (data[pos - 1] < 0) { // 1..n
                return pos;
            } else {
                data[pos - 1] = -data[pos - 1];
            }
        }

        return -1;
    }
}