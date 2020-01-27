// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/python/cafe-order-checker?course=fc1&section=array-and-string-manipulation

public class CafeOrderChecker {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] takeOutOrders = new int[]{1, 3, 5};
        int[] dineInOrders = new int[]{2, 4, 6};
        int[] servedOrders1 = new int[]{1, 2, 4, 6, 5, 3}; // False
        int[] servedOrders2 = new int[]{1, 2, 3, 5, 4, 6}; // True

        System.out.println("Is valid: " + orderChecker(dineInOrders, takeOutOrders,                     servedOrders1));
        System.out.println("Is valid: " + orderChecker(dineInOrders, takeOutOrders,                     servedOrders2));

    }

    private static boolean orderChecker(int[] in, int[] out, int[] served) {
        int i = 0, j = 0;

        for (int k = 0; k < served.length; k++) {
            int s = served[k];
            if (i < in.length && s == in[i]) {
                i++;
            } else if (j < out.length && s == out[j]) {
                j++;
            } else {
                return false;
            }
        }

        return true;
    }
}

        /*
        Watch out for index out of bounds errors! Will your method ever try to grab the 0th         item from an empty array, or the nth item from an array with n elements          (where the last index would be n−1)?

    This assumes each customer order in servedOrders is unique. How can we adapt this to handle arrays of customer orders with potential repeats?
    Our implementation returns true when all the items in dineInOrders and takeOutOrders are first-come first-served in servedOrders and false otherwise. That said, it'd be reasonable to throw an exception if some orders that went into the kitchen were never served, or orders were served but not paid for at either register. How could we check for those cases?
    Our solution iterates through the customer orders from front to back. Would our algorithm work if we iterated from the back towards the front? Which approach is cleaner?
        */