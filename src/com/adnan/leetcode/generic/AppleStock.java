// "static void main" must be defined in a public class.

public class AppleStock {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] stockPrices1 = new int[] {10, 7, 5, 8, 11, 9};
        int[] stockPrices2 = new int[] {10, 9, 8, 7, 6, 2};

        System.out.println(getMaxProfit(stockPrices1));
        // returns 6 (buying for $5 and selling for $11)
    }

    private static int getMaxProfit(int[] stocks) {
        int currentMin = stocks[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < stocks.length; i++) {
            int s = stocks[i];
            int m = s - currentMin;
            if (m > max) {
                max = m;
            }

            if (s < currentMin) {
                currentMin = s;
            }
        }

        return max;
    }
}