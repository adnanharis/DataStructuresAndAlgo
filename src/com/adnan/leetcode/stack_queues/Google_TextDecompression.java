// "static void main" must be defined in a public class.
// https://techdevguide.withgoogle.com/resources/compress-decompression/
import java.util.*;

public class Google_TextDecompression {
    public static void main(String[] args) {
        String s1 = "3[abc]4[ab]c";
        String result = decompress(s1);
        System.out.println(s1 + " = " + result + " : " + result.equals("abcabcabcababababc"));

        String s2 = "10[a]";
        result = decompress(s2);
        System.out.println(s2 + " = " + result + " == " + result.equals("aaaaaaaaaa"));

        String s3 = "2[3[a]b]";
        result = decompress(s3);
        System.out.println(s3 + " = " + result + " : " + result.equals("aaabaaab"));

        String s4 = "3[abc]4[ab]c10[a]2[3[a]b]";
        result = decompress(s4);
        System.out.println(s4 + " = " + result + " : " + result.equals("abcabcabcababababcaaaaaaaaaaaaabaaab"));

        String s5 = "a[]b";
        result = decompress(s5);
        System.out.println(s5 + " = " + result + " : " + result.equals("ab"));

        String s6 = "0[abc]";
        result = decompress(s6);
        System.out.println(s6 + " = " + result + " : " + result.equals(""));
    }

    private static String decompress(String data) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> digitStack = new Stack<>();

        boolean isDigitFoundAlready = false;
        for (char c : data.toCharArray()) {
            if (Character.isDigit(c)) {
                // Its a digit so push into digit stack by handling multi-digit
                int d = Character.getNumericValue(c);
                if (isDigitFoundAlready) {
                    int m = digitStack.pop();
                    d = m * 10 + d;
                }
                digitStack.push(d);
                isDigitFoundAlready = true;
            } else if (c == ']') {
                isDigitFoundAlready = false;
                StringBuilder sb = new StringBuilder();

                // Pop and build string until we get ']'
                while (!stringStack.isEmpty()) {
                    String s = stringStack.pop();
                    if (s.equals("[")) {
                        break;
                    }

                    sb.insert(0, s);
                }

                // Repeat that built string into number of digits
                if (digitStack.isEmpty()) {
                    continue; // TO handle edge case a[]b
                }

                int d = digitStack.pop();
                String s = repeat(sb.toString(), d);
                stringStack.push(s);
            } else {
                // Just push it to the string stack
                isDigitFoundAlready = false;
                stringStack.push(String.valueOf(c));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            if (stringStack.isEmpty()) {
                break;
            }
            sb.insert(0, stringStack.pop());
        }

        return sb.toString();
    }

    private static String repeat(String text, int digit) {
        StringBuilder sb = new StringBuilder();
        while(digit-- > 0) {
            sb.append(text);
        }

        return sb.toString();
    }
}