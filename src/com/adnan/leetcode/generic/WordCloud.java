// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/python/word-cloud?course=fc1&section=hashing-and-hash-tables
import java.util.*;

public class WordCloud {
    public static void main(String[] args) {
        String s1 = "After beating the eggs, Dana read the next step eggs:";
        String s2 = "Add milk and eggs, then add flour and sugar.";
        String s3 = "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake. I'm singing ♬ on a ☔ day. ☹ + ☕ = ☺.";
        Map<String, Integer> map = getWordCloud(s3);
        print(map);
    }

    private static Map<String, Integer> getWordCloud(String data) {
        System.out.println(data + '\n');
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        for (char c : data.toCharArray()) {
            if (isLetter(c)) {
                sb.append(c);
            } else {
                if (sb.length() != 0) {
                    String t = sb.toString().toLowerCase();
                    map.put(t, map.getOrDefault(t, 0) + 1);
                }
                sb = new StringBuilder();
            }
        }

        return map;
    }

    private static boolean isLetter(char c) {
        int A = 0x41;
        int Z = 0x41 + 25;
        int a = 0x61;
        int z = 0x61 + 25;

        int x = (int) c;
        if ((A <= x && x <= Z) || (a <= x && x <= z)) {
            return true;
        }

        // Handle hyphenated words
        int hyp = (int) '-';
        if (x == hyp) {
            return true;
        }

        // Handle unicode
        if (x > 127) {
            return true;
        }

        return false;
    }

    private static void print(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            Integer count = entry.getValue();
            System.out.println(word + " " + count);
        }
    }
}