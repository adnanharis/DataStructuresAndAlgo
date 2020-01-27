// "static void main" must be defined in a public class.

public class MakingChange {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] denominations = new int[]{1, 2, 3};
        int amount = 4;

        // for (int i = 0; i < denominations.length; i++) {
        //     getChange(denominations, amount, i);
        // }
        // System.out.println("Count: " + count);

        int possibilities = changePossibilitiesTopDown(amount, denominations);
        System.out.println("Count: " + possibilities);
    }

    // ----- Mine -----
    /*
    static int count = 0;
    // static Set<Integer> set = new HashSet<Integer>();
    private static void getChange(int[] denominations, int amount, int n) {
        if (n < 0) {
            return;
        }

        if (amount <= 0) {
            return;
        }

        int c = denominations[n];

        int subAmount = amount % c;
        System.out.println(amount + " " + c + " " + subAmount);

        if (subAmount == 0) {
            count++;
        } else {
            getChange(denominations, subAmount, n - 1);
            return;
        }

        getChange(denominations, amount - c, n - 1);
    }
    */

    // --- interview cake ----
    public static int changePossibilitiesTopDown(int amount, int[] denominations) {
        return changePossibilitiesTopDown(amount, denominations, 0);
    }

    private static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex) {

        // base cases:
        // we hit the amount spot on. yes!
        if (amountLeft == 0) {
            return 1;
        }

        // we overshot the amount left (used too many coins)
        if (amountLeft < 0) {
            return 0;
        }

        // we're out of denominations
        if (currentIndex == denominations.length) {
            return 0;
        }

        System.out.printf("checking ways to make %d with %s\n",
                amountLeft, Arrays.toString(Arrays.copyOfRange(denominations,
                        currentIndex, denominations.length)));

        // choose a current coin
        int currentCoin = denominations[currentIndex];

        // see how many possibilities we can get
        // for each number of times to use currentCoin
        int numPossibilities = 0;
        while (amountLeft >= 0) {
            numPossibilities += changePossibilitiesTopDown(amountLeft, denominations,
                    currentIndex + 1);
            amountLeft -= currentCoin;
        }

        return numPossibilities;
    }

}