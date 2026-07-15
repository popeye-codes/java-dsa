package com.shivam.hashmaps.questions;
import java.util.*;

// strs = ["eat","tea","tan","ate","nat","bat"]
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> result = new ArrayList<>();

        HashMap<Character, Integer> freqMap;

        boolean isAnagram = true; /// flag

        boolean[] visited = new boolean[strs.length]; /// isVisited?

        for(int i = 0; i < strs.length; i++) {
            ArrayList<String> list = new ArrayList<>(); // internal - list


            /// it's visited => skip, to prevent checking for Anagram for Same String
            if (visited[i]) {
                continue;
            }



            list.add(strs[i]);

            for (int j = i + 1; j < strs.length ; j++) { // string - 2

                if (strs[i].length() != strs[j].length()) {
                    continue;
                }

                /// This check is -> to prevent duplicates grouping
                if (visited[j]) {
                    continue;
                }

                freqMap = frequencyMap(strs[i]); // frequency of each - Char of each String of i.

                // for decrement of frequency
                for (char ch : strs[j].toCharArray()) {

                    if (!freqMap.containsKey(ch) || freqMap.get(ch) == 0) { /// key is not there Or key is there but freq = 0, so by further decrement freq -> -ve => Not Anagram

                        isAnagram = false; /// set flag -> false

                        break;
                    }

                    // if ch -> is as key
                    freqMap.put(ch, freqMap.get(ch) - 1);  // decrease the frequency by one
                }

                // check ?
                if (isAnagram) { // --> true
                    for (int freq : freqMap.values()) {
                        if (freq != 0) {
                            isAnagram = false; /// set to -> false
                            break;
                        }
                    }
                }


                if (isAnagram) {
                    /// isAnagram -> true => add into list
                    list.add(strs[j]);

                    /// visited  j set -> as true
                    visited[j] = true;
                }

                /// reset the flag
                isAnagram = true;

            }

            result.add(list);
        }

        return result;

    }

    static HashMap<Character, Integer> frequencyMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }


    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};

        System.out.println("Original String Array: " + Arrays.toString(str));
        System.out.println(groupAnagrams(str));
    }
}
