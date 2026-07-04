package com.shivam;


public class TClass {
    private ListNode head;


    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int[] arr = new int[31];
        int i = 0;
        while (temp != null) {
            arr[i] = temp.val;
            temp = temp.next;
        }

        int decimalVal = 0;

        for (int j = arr.length - 1; j > 0; j--) {
            int n = 0;
            decimalVal += (arr[j] * Math.pow(2, n));
            n += 1;
        }

        return decimalVal;

    }

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
