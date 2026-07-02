package com.shivam.largenumbers;
import java.math.BigDecimal;

public class BIgDecimal {
    public static void main(String[] args) {
        BD();
    }

    static void BD() {
        double x = 0.03;
        double y = 0.04;
//        double ans = y - x;
//        System.out.println(ans);

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
//        BigDecimal ans = Y.subtract(X);

//        System.out.println(ans);


        BigDecimal a = new BigDecimal("4646565464.78576979");
        BigDecimal b = new BigDecimal("8787587687.87668898");

        ///  operation
        System.out.println("Add: " + b.add(a));
        System.out.println("Sub: " + b.subtract(a));
        System.out.println("Multiply: " + b.multiply(a));
        System.out.println("Square: " + a.pow(2));



    }
}
