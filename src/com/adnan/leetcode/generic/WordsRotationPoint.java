// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/python/find-rotation-point?course=fc1&section=sorting-searching-logarithms

public class WordsRotationPoint {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };

        int rotatePoint = getTheRotatePoint(words, 0, words.length - 1);
        System.out.println(rotatePoint + " | Word:" + words[rotatePoint]);
    }

    private static int getTheRotatePoint(String[] words, int l, int h) {
        if (l >= h || (l + 1 == h)) {
            return h;
        }

        int m = l + (h - l) / 2;
        // System.out.println(l + " " + h + " " + m);
        if (words[l].compareTo(words[m]) > 0) {
            h = m;
        } else if (words[m].compareTo(words[h]) > 0) {
            l = m;
        }

        return getTheRotatePoint(words, l, h);
    }
}