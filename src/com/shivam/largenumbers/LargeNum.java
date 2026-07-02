package com.shivam.largenumbers;

import java.math.BigInteger;

public class LargeNum {
    public static void main(String[] args) {
        int a = 30;
        int b = 67;

        BigInteger A = BigInteger.valueOf(3);
        BigInteger B = BigInteger.valueOf(336); /// converting int Or long into BI

        ///  to convert BI to int
        int c = B.intValue();

        // if number out of Int or Long Scope Use String by making Object
        BigInteger C = new BigInteger("4687666996898686");


        /// constants as big Integer
        BigInteger D = BigInteger.TEN;

        ///  addition
        BigInteger s = A.add(B);
        System.out.println(s);

        BigInteger rem = s.remainder(A);
        System.out.println("Remainder: " + rem);
        // lly, divide , Subtract, Multiply


        ///  compare
        if (A.compareTo(B) < 0) {
            System.out.println("true");
        }
        else {
            System.out.println(false);
        }
    }

}
