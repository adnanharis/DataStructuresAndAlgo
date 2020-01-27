// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/recursive-string-permutations?course=fc1&section=dynamic-programming-recursion

public class RecursiveStringPermutation {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String str = "abc";
        // String[] res = permutation(str, str.length() - 1);
        // print(res);
        Set<String> res = permutationSet(str, str.length() - 1);
        System.out.println(res);
    }

    // Using string[]: will have duplicates for repeated char in string
    private static String[] permutation(String str, int n) {
        if (n == 0) {
            return new String[]{Character.toString(str.charAt(n))};
        }

        String[] chunks = permutation(str, n - 1);
        char a = str.charAt(n);
        String[] list = new String[chunks.length * (n+1)];
        int k = 0;
        for (String subStr: chunks) {
            for (int i = 0; i <= subStr.length(); i++) {
                list[k++] = subStr.substring(0, i) + a + subStr.substring(i);
            }
        }

        return list;
    }

    // Using Set: Will avoid duplicates
    private static Set<String> permutationSet(String str, int n) {
        if (n == 0) {
            Set<String> set = new HashSet<>();
            set.add(Character.toString(str.charAt(n)));
            return set;
        }

        Set<String> prevSet = permutationSet(str, n - 1);
        char a = str.charAt(n);
        Set<String> set = new HashSet<>();
        for (String subStr: prevSet) {
            for (int i = 0; i <= subStr.length(); i++) {
                set.add(subStr.substring(0, i) + a + subStr.substring(i));
            }
        }

        return set;
    }

    private static void print(String[] arr) {
        for (String s: arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}