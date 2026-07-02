package com.shivam.recursion;

public class CountNoOfZeroInDecimal {
    public static void main(String[] args) {

        int n = 20800;
        int ans = countZero_Digits(n);
        System.out.println(ans);
    }

    static int countZero_Digits(int n){
        int count = 0;
        if( n == 0 ) {
            return 0;
        }

        else if(n % 10 == 0) count++;

        return countZero_Digits(n/10) + count;


    }
}

/*
🧠 Key rule to remember (very important)
Prefix	Meaning
0	Octal (base 8)
0x	Hexadecimal
0b	Binary
No prefix	Decimal
🎯 Interview-level takeaway

Leading zeros don’t exist in integers.
They are formatting, not numeric value.

If you care about digits → use String
If you care about value → use int/long
 */