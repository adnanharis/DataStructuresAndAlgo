/**
 Write a method that takes an array of characters and reverses the letters in place.
 https://www.interviewcake.com/question/java/reverse-string-in-place?course=fc1&section=array-and-string-manipulation
 */

public class ReverseStringCharInPlace {
    public static void main(String[] args) {
        System.out.println("Reverse a string chars In Place");
        char[] string = new char[10];
        string[0] = 'a';
        string[1] = 'b';
        string[2] = 'c';
        string[3] = 'd';
        string[4] = 'e';
        string[5] = 'f';
        string[6] = 'g';
        string[7] = 'h';
        string[8] = 'i';
        string[9] = 'j';

        print(string);

        // reverse
        int i = 0;
        int j = string.length - 1;
        char c;
        while (i <= j) {
            c = string[i];
            string[i] = string[j];
            string[j] = c;
            i++;
            j--;
        }

        System.out.println();
        print(string);
    }

    private static void print(char[] string) {
        for (char c : string) {
            System.out.print(c + " ");
        }
    }
}