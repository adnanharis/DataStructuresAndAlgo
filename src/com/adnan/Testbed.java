package com.adnan;

import java.util.*;

public class Testbed {

    public static void main(String[] args) {

        String s1 = "ABC";
        String s2 = new String("ABC");
        int i1 = 1;
        Integer i2 = new Integer(1);

        System.out.println(s1 + " : " + s2 + " : " + i1 + " : " + i2);
        System.out.println((s1 == s2) + " : " + (i1 == i2));
        System.out.println(new Student() + " : " + new Student[5]);
        System.out.println(new Teacher() + " : " + new Teacher[5][5]);

        System.out.println("Hash:" + new String("AaAaAaAa").hashCode() + " : " + new String("AaAaAaBB").hashCode());

        Hashtable h;
        HashMap m;
        List l;
        Object o = new Object();
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q; // = new Queue<Integer>(); // Cannot create the object of queue bc its an interface
        Queue<Integer> dq = new ArrayDeque();
        dq.add(1);
        dq.poll();
    }

    static class Student {

    }
}

class Teacher {

}