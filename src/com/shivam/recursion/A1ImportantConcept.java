package com.shivam.recursion;

public class A1ImportantConcept {
    public static void main(String[] args){
        int n = 5;
        concept(n);
    }

    // vvi - CONCEPT

    static void concept(int n){
        if (n == 0) return;

        System.out.println(n);

//       concept(n--);  => As it's post - decrement so value pass to next call without Even
//       decremented. Hence, Stack Over-flow

        // true version Using Pre - decrement i.e; --n

        concept(--n);
    }


}
