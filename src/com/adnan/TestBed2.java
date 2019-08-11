package com.adnan;

import java.util.Comparator;

public class TestBed2 {

    public static void main(String[] args) {
	    // write your code here

        ExtendingComparator base = new ExtendingComparator();
        ExtendingComparator base2 = new Child();

        base.compare("123", "1234");
        base2.compare("123", "1234");

        System.out.println("Test 1 : " + base.i);
        System.out.println("Test 2 : " + base2.i);
    }
}

class MaxPriorityQueue<T extends Comparable<T>> {

}

class ExtendingComparable implements Comparable<String> {

    @Override
    public int compareTo(String o) {
        return 0;
    }
}

class ExtendingComparator implements Comparator<String> {
    int i = 1;

    @Override
    public int compare(String o1, String o2) {
        System.out.println("Base: " + i);
        return o1.compareTo(o2);
    }
}

class Child extends ExtendingComparator {
    int i = 2;

    @Override
    public int compare(String o1, String o2) {
        System.out.println("Child: " + i);
        return super.compare(o1, o2);
    }
}
