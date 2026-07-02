package com.shivam.recursion;

public class StringReverseLeetCode344 {
    public static void main(String[] args) {
        String[] arr = {"s", "h", "i", "v", "a", "m"};
        int n = arr.length - 1;
        String result = fun(0, arr, n);
        System.out.println(result);
        System.out.println((char) ('a' + 1));

    }

    static String fun(int i, String[] arr, int n) {
        if (i == n) {
            return arr[i]; // Not stuck here, Now
        }
        return fun(i + 1, arr, n) + arr[i];
    }
}

/*
❗ Key realization (lock this in)

System.out.println does NOT print recursion steps.
It prints the final returned value only.
Recursion is doing string construction, not printing.

        🧠 One-line mental model (very powerful)
“Each recursive call waits, then adds its own character while returning.”
*/

/*
Returning to fun(4)
Code at fun(4):
        return fun(5) + arr[4];
Substitute value:
        = "m" + "a"
        = "ma"
So:
fun(4) returns "ma"
        🔹 Returning to fun(3)
return fun(4) + arr[3];
Substitute:
        = "ma" + "v"
        = "mav"
So:
fun(3) returns "mav"
        🔹 Returning to fun(2)
return fun(3) + arr[2];
        = "mav" + "i"
        = "mavi"
        🔹 Returning to fun(1)
return fun(2) + arr[1];
        = "mavi" + "h"
        = "mavih"
        🔹 Returning to fun(0)
return fun(1) + arr[0];
        = "mavih" + "s"
        = "mavihs"
        ✅ FINAL RESULT
Now main receives:
result = "mavihs";
        System.out.println(result);
Only NOW printing happens.
        🧠 IMPORTANT VISUAL SUMMARY
Call stack behavior:
DOWN  → break problem
UP    → build answer
Who adds characters?
Function	Adds
fun(5)	m
fun(4)	a
fun(3)	v
fun(2)	i
fun(1)	h
fun(0)	s
❗ Key realization (lock this in)
System.out.println does NOT print recursion steps.
It prints the final returned value only.
Recursion is doing string construction, not printing.

        🧠 One-line mental model (very powerful)
“Each recursive call waits, then adds its own character while returning.”

*/
