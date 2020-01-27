// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/simulate-5-sided-die?course=fc1&section=combinatorics-probability-math
// Worst-case O(∞) infty time (we might keep re-rolling forever) and O(1) space

public class Rand5FromRand7 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        for (int i = 0; i < 10; i++) {
            System.out.println(rand5());
        }
    }

    private static int rand5() {
        int result = rand7();
        while (result > 5) {
            result = rand7();
        }

        return result;
    }

    private static int rand5_recursive() {
        int result = rand7();
        return (result <= 5) ? result : rand5_recursive();
    }

    static Random random = new Random(); // 0 - 6
    private static int rand7() {
        return random.nextInt(6) + 1;
    }
}