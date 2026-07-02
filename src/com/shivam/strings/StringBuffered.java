package com.shivam.strings;
import java.lang.StringBuffer;
import java.util.Arrays;
import java.util.Random;
import java.text.DecimalFormat;
public class StringBuffered {
    public static void main(String[] args) {

        /// constructor 1: // default capacity => 16
        StringBuffer sb = new StringBuffer();

        /// constructor 2: => have already initialised String in it
        StringBuffer sb2 = new  StringBuffer("Shiva raj");
        System.out.println("Default Capacity Of StringBuilder: " + sb.capacity());

        /// constructor 3: => specify capacity
        StringBuffer sb3 = new  StringBuffer(30);

        sb.append("WeMakeDevs");
        sb.append(" is nice!");

        /// sb.insert(2, " Rahul ");

        sb.replace(1, 5, "Kushwaha");

        sb.delete(1, 5);

        String str = sb.toString();
        System.out.println(str);

        /// random Number
        Random random = new Random();
        System.out.println(random.nextFloat());
        System.out.println((char) (97 + 1));

        ///  remove whiteSpace
        String sentence = " Hi h   hjh  hjkso  siowl    w";
        System.out.println(sentence);

        System.out.println(sentence.replace("\s", ""));


        ///  split
        String arr = "Shiv Shiva Apple";
        String[] names = arr.split(" "); // in String wherever there is COMMAS cut it from there
        System.out.println(Arrays.toString(names));


        ///  round - off
        DecimalFormat df = new DecimalFormat("00.0000");
        System.out.println(df.format(7.29));

        ///  Unicode Character????
    }
}
