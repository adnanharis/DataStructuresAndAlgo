// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/product-of-other-numbers?course=fc1&section=greedy
/*
To find the products of all the integers except the integer at each index, we'll go through our array greedily ↴ twice. First we get the products of all the integers before each index, and then we go backwards to get the products of all the integers after each index.
*/
public class ProductOfAllExceptIndex {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] list = new int[]{1, 2, 6, 5, 9};
        System.out.println(Arrays.toString(getProductOfAllExceptIndex(list)));
    }

    private static int[] getProductOfAllExceptIndex(int[] data) {

        int[] products = new int[data.length];

        // before index
        int prevProduct = 1;
        for (int i = 0; i < data.length; i++) {
            products[i] = prevProduct;
            prevProduct *= data[i];
        }

        // after index
        // and instead of storing in a diff array to save space do the 3rd step of multiplying these two array in this step only
        prevProduct = 1;
        for (int i = data.length - 1; i >= 0; i--) {
            products[i] *= prevProduct;
            prevProduct *= data[i];
        }

        return products;
    }
}