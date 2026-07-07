package com.shivam.hashmaps.questions;

import java.util.HashMap;


///  LexicoGraphically -> Alphabet which comes first in (a, b, c...)
public class MostFrequentCharacter {
    public static char getMaxOccurChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        ///  we are storing char with there frequency.
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) { /// if in Map char is Already
                int freq = map.get(ch); /// get that key - frequency => overwrite
                map.put(ch, freq + 1);
            } else {
                map.put(ch, 1); /// if it's first time => add in Map
            }
        }

        /// to find max
        int maxFreq = 0;
        char ans = Character.MAX_VALUE;

        // loop to iterate over whole Map
        for (char ch : map.keySet()) {
            int freq = map.get(ch); /// accessing character frequency

            if (freq > maxFreq) {
                maxFreq = freq;
                ans = ch;
            } else if (freq == maxFreq && ch < ans) { /// 🌟 (ch < ans) -> character is being compared with ASCII - value
                ans = ch;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "output";
        System.out.println(getMaxOccurChar(s));
    }
}
