package com.shivam.recursion;
import java.lang.String;
public class StringPalindrome {
    public static void main(String[] args) {
        String str = "abcbahj";
        boolean ans = isPalindrome(str);
        System.out.println(ans);
    }

    static boolean isPalindrome(String str) {
        int len = str.length();
        if (str.length() <= 1) {
            return true;
        }

        String first = str.substring(0, 1);
        String last = str.substring(len - 1, len);

        // substring Range = [starIdx, lastIdx) & substring() gives String within range.
        if (first.equals(last)) {
            return isPalindrome(str.substring(1, len - 1)); // Eliminating first and last character
        }
        return false;

    }
}
