// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/permutation-palindrome?course=fc1&section=hashing-and-hash-tables
import java.util.*;

public class PermutationPalindromeString {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String text = "civic";
        String text1 = "ivicc";
        String text2 = "civil";
        String text3 = "livci";
        System.out.println("Is Palindrome: " + isPalindrome(text));
        System.out.println("Is Palindrome: " + isPalindromeBEAST(text));
    }

    private static boolean isPalindrome(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        boolean isSingleOne = false;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) it.next();
            int v = (int) mapEntry.getValue();
            if (v % 2 == 0) {
                continue;
            } else if (!isSingleOne) {
                isSingleOne = true;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindromeBEAST(String text) {
        Set<Character> charSet = new HashSet<>();
        for (char c : text.toCharArray()) {
            if (charSet.contains(c)) {
                charSet.remove(c);
            } else {
                charSet.add(c);
            }
        }

        int size = charSet.size();
        if (size >= 2) {
            return false;
        }

        return true;
    }
}