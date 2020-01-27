// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/cake-thief?course=fc1&section=dynamic-programming-recursion

public class CakeThief {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        CakeType[] cakeTypes = new CakeType[] {
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15),
        };

        int capacity = 20;

        int max = maxDuffelBagValue(cakeTypes, capacity);
        System.out.println(max);
    }

    // 0-1 Knapsack problem DP
    /*
    For all cakes, go from (capacities) 0..capacity
    For a given a weight, check if the value of the current item + value of
    the item that we could afford (more) with the remaining weight is
    greater than the value without the current item itself
    */
    private static int maxDuffelBagValue(CakeType[] cakeTypes, int capacity) {
        int[] values = new int[capacity + 1];
        values[0] = 0;

        for (CakeType cake : cakeTypes) {
            for (int i = 1; i < values.length; i++) {
                if (i >= cake.weight) {
                    // max of current cake with + prev cakes that we could afford (more) with the remaining weight WITH current max (in matrix its prev max at same position. Here we are reusing the space)
                    values[i] = Math.max(cake.value + values[i-cake.weight], values[i]);
                } else {
                    values[i] = values[i-1];
                }
            }
            System.out.println(Arrays.toString(values));
        }

        return values[values.length - 1];
    }
}

class CakeType {

    final int weight;
    final int value;

    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value  = value;
    }
}