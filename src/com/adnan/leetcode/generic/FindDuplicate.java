// "static void main" must be defined in a public class.
//
public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] data = new int[]{1, 2, 2, 3, 4, 5};
        System.out.println(findDuplicate(data));
    }

    private static int findDuplicate(int[] data) {
        int totalSum = 0;
        int arraySum = 0;
        int max = 0;

        for (int i = 1; i <= data.length; i++) {
            max = Math.max(max, data[i - 1]);
            arraySum += data[i - 1];
        }

        while (max != 0) {
            totalSum += max--;
        }

        return arraySum - totalSum;
    }
}