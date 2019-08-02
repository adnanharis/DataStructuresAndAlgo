package com.adnan;

import java.util.HashMap;
import java.util.Hashtable;

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


        Hashtable h;
        HashMap m;
    }

    static class Student {

    }
}

class Teacher {

}