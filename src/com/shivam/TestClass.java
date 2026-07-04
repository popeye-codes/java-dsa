package com.shivam;


import java.util.Stack;

public class TestClass {

    // valid parenthesis
    public static boolean isValid(String string) {
        Stack<Character> stack = new Stack<>();

        for (Character ch : string.toCharArray()) {


            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                    else if (stack.peek() == '{') {
                        stack.pop();
                    }
                    else if (stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = ")";
        boolean result = isValid(str);
        System.out.println(result);
    }
}
