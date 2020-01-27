// "static void main" must be defined in a public class.
public class NthFabonacciNumber {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // 0,1,1,2,3,5,8,13,21...
        int n = 8;
        int f = fab(n);
        System.out.println("\n>" + n + ": " + f);

        // recursive and DP using HashMap
        f = fabDP(n);
        System.out.println("\n>" + n + ": " + f);

        // non-recursive and DP using array[n + 1]
        f = dabDP_BEAST(n);
        System.out.println("\n>" + n + ": " + f);

        // non-recursive and DP using array[2]
        f = dabDP_SUPER_BEAST(n);
        System.out.println("\n>" + n + ": " + f);
    }

    private static int fab(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        System.out.print(n + " ");
        return fab(n - 1) + fab(n - 2);
    }

    static Map<Integer, Integer> map = new HashMap<>();
    private static int fabDP(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        Integer f;
        if (map.containsKey(n)) {
            f = map.get(n);
        } else {
            System.out.print(n + " ");
            f = fabDP(n - 1) + fabDP(n - 2);
            map.put(n, f);
        }

        return f;
    }

    private static int dabDP_BEAST(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] fab = new int[n + 1];
        fab[0] = 0;
        fab[1] = 1;
        for (int i = 2; i <= n; i++) {
            fab[i] = fab[i - 1] + fab[i - 2];
        }

        return fab[n];
    }

    private static int dabDP_SUPER_BEAST(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] fab = new int[2];
        fab[0] = 0;
        fab[1] = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = fab[0] + fab[1];
            fab[0] = fab[1];
            fab[1] = temp;
        }

        return fab[1];
    }
}