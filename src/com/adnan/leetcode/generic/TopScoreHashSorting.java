// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/top-scores?course=fc1&section=hashing-and-hash-tables

public class TopScoreHashSorting {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] unsortedScores = {37, 89, 41, 37, 65, 91, 53};
        final int HIGHEST_POSSIBLE_SCORE = 100;

        int[] sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
        System.out.println(Arrays.toString(sortedScores));
        // sortedScores: [91, 89, 65, 53, 41, 37]
    }

    private static int[] sortScores(int[] unsorted, int max) {
        // We can save the space by reusing the unsorted array
        int[] sorted = new int[unsorted.length];
        int hash[] = new int[max + 1];

        for (int e : unsorted) {
            hash[e] += 1;
        }

        int k = 0;
        for (int i = hash.length - 1; i >= 0; i--) {
            if (hash[i] != 0) {
                for (int j = 0; j < hash[i]; j++) {
                    sorted[k++] = i;
                }
            }
        }

        return sorted;
    }

}