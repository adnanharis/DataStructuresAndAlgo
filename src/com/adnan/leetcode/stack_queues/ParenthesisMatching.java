// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/python/matching-parens?course=fc1&section=queues-stacks

public class ParenthesisMatching {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String message  = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        int pos = 10; // 28
        int endingPos = getClosingIndex(message, pos);
        System.out.println(endingPos);
    }

    private static int getClosingIndex(String message, int pos) {
        if (message.charAt(pos) != '(') { // == check bc its char not Character (equals)
            return -1;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for(int i = pos; i < message.length(); i++) {
            Character c = message.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    return i;
                }
            }
        }

        return -1;
    }
}