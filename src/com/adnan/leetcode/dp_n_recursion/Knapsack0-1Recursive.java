// "static void main" must be defined in a public class.

public class Knapsack0-1Recursiv {

    static int[][] arr;
    public static void main(String[] args) {
        System.out.println("Hello World!");

        CakeType[] cakeTypes = new CakeType[] {
                new CakeType(0, 0), // Dummy
                new CakeType(5, 10),
                new CakeType(4, 40),
                new CakeType(6, 30),
                new CakeType(3, 50),
        };
        int capacity = 10;

        // CakeType[] cakeTypes = new CakeType[] {
        //     new CakeType(0, 0),
        //     new CakeType(7, 160),
        //     new CakeType(3, 90),
        //     new CakeType(2, 15),
        // };
        // int capacity = 20;

        arr = new int[cakeTypes.length][capacity + 1];
        System.out.println(knapsack(cakeTypes, capacity, cakeTypes.length-1));
        System.out.println("---");
        System.out.println(knapsackDP(cakeTypes, capacity, cakeTypes.length-1));
    }

    private static int knapsack(CakeType[] cakeTypes, int capacity, int n) {
        System.out.println(capacity + " " + cakeTypes[n].weight);
        if (n == 0) {
            return 0; // cakeTypes[n].value; // without dummy but wrongs
        }

        if (cakeTypes[n].weight <= capacity) {
            int t1 = knapsack(cakeTypes, capacity, n - 1);
            int t2 = cakeTypes[n].value + knapsack(cakeTypes, capacity - cakeTypes[n].weight, n - 1);
            return Math.max(t1, t2);
        } else {
            return knapsack(cakeTypes, capacity, n - 1);
        }
    }

    private static int knapsackDP(CakeType[] cakeTypes, int capacity, int n) {
        if (arr[n][capacity] != 0) {
            return arr[n][capacity];
        }
        System.out.println(capacity + " " + cakeTypes[n].weight);
        int result;
        if (n == 0) {
            result = 0; // cakeTypes[n].value; // without dummy but wrongs
        } else if (cakeTypes[n].weight <= capacity) {
            int t1 = knapsackDP(cakeTypes, capacity, n - 1);
            int t2 = cakeTypes[n].value + knapsackDP(cakeTypes, capacity - cakeTypes[n].weight, n - 1);
            result =  Math.max(t1, t2);
        } else {
            result = knapsackDP(cakeTypes, capacity, n - 1);
        }

        arr[n][capacity] = result;
        return result;
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