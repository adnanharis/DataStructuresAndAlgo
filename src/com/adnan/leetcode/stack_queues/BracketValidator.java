// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/python/bracket-validator?course=fc1&section=queues-stacks
// O(n) time (one iteration through the string), and O(n)O(n)O(n) space (in the worst case, all of our characters are openers, so we push them all onto the stack)

public class BracketValidator {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String m1 = "{[]()}"; // True
        String m2 = "{[(])}"; // False
        String m3 = "{[}"; // False
        String m4 = "{[]}}"; // False

        System.out.println(m1 + " " + validate(m1));
        System.out.println(m2 + " " + validate(m2));
        System.out.println(m3 + " " + validate(m3));
        System.out.println(m4 + " " + validate(m4));
    }

    private static boolean validate(String text) {
        if (text.length() == 0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : text.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    stack.push(c);
                    break;

                case '}':
                    if (stack.isEmpty() || !stack.pop().equals('{')) {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals('(')) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || !stack.pop().equals('[')) {
                        return false;
                    }
                    break;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}