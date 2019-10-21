
package com.leo.leetcode.lc0819;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        //corner

        //init
        String[] words = paragraph.toLowerCase().split("\\W+");
        HashMap<String, Integer> wordMap = new HashMap<>();
        HashSet<String> bannedSet = new HashSet<>();
        int max = 0;
        String res = "";

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (String str : banned) {
            bannedSet.add(str);
        }
        //iter
        for (String word : wordMap.keySet()) {
            if (!bannedSet.contains(word) && wordMap.get(word) > max) {
                max = Math.max(max, wordMap.get(word));
                res = word;
            }
        }
        //return
        return res;
        //return Collections.max(wordMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    //t: O(n)
    //s: O(n) n = string array of paragraph length
    public static void main(String[] args) {
        // Creating an empty Map
        Map<Integer, String> map = new HashMap<Integer, String>();

        // Mapping string values to int keys
        map.put(10, "Geeks");
        map.put(15, "4");
        map.put(20, "Geeks");
        map.put(25, "Welcomes");
        map.put(30, "You");

        // Displaying the Map
        System.out.println("Initial Mappings are: " + map);

        // Using entrySet() to get the set view
        System.out.println("The set is: " + map.entrySet());
    }

}
