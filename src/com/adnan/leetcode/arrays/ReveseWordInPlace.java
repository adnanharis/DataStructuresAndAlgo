// "static void main" must be defined in a public class.
public class ReveseWordInPlace {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        char[] message = { 'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l' };

        System.out.println(message);
        reverseWords(message);
        System.out.println(message);
        // prints: "steal pound cake"
    }

    private static void reverseWords(char[] message) {
        int s = 0;
        int e = 0;

        while (e < message.length) {
            if (message[e] == ' ') {
                reverse(message, s, e - 1);
                s = e + 1;
            } else if (e == message.length - 1) {
                reverse(message, s, e);
            }
            e++;
        }

        reverse(message, 0, message.length - 1);
    }

    private static void reverse(char[] message, int s, int e) {
        char t;
        while (e >= s) {
            t = message[s];
            message[s++] = message[e];
            message[e--] = t;
        }
    }

    private static void print (char[] message) {
        for (int i = 0; i < message.length; i++) {
            System.out.print(message[i]);
        }
    }
}