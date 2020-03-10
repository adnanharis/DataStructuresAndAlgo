import java.util.*;

/**
 * Find if a given string has all unique characters with same frequency.
 * Eg "aabbcc" is valid but "aabbccc" in invalid
 */

public class HelloWorld {

    public static void main(String []args){
        System.out.println("Hello World");

        String text = "aabbcc";
        boolean isValid = isValid(text);
        System.out.println("isValid: " + isValid);
    }

    private static boolean isValid(String text) {
        if (text.isEmpty()) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>(); // Empty bag
        char[] chars = text.toCharArray();
        for (char c : chars) {
            Integer count = map.get(c);
            count = count == null ? 1 : ++count;
            map.put(c, count);
        }

        Integer count = null;
        /*for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer currentCount = entry.getValue();
            if (count == null) {
                count = currentCount;
            } else if (count != currentCount) {
                return false; // fail fast
            }
        }*/

        for (Integer currentCount : map.values()) {
            // Integer currentCount = entry.getValue();
            if (count == null) {
                count = currentCount;
            } else if (count != currentCount) {
                return false; // fail fast
            }
        }

        return true;
    }
}

/*

1. String is empty : true
2. string is not valid : false
3. string is valid : true

STEP 1:
Build the hashmap : key: char, val: count
O(n)

STEP 2:
iterate over hashmap and check each count is equal to each other
O(n)
*/