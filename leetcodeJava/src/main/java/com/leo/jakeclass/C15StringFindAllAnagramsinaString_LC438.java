package com.leo.jakeclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C15StringFindAllAnagramsinaString_LC438 {
        public static List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> map = new HashMap<>();
            for(char c: p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

            int fast = 0;
            int slow = 0;
            int ct = map.size();
            List<Integer> result = new ArrayList<>();

            while(fast < s.length()) {
                char right = s.charAt(fast);
                if(map.containsKey(right)) {
                    map.put(right, map.get(right) - 1);
                    if (map.get(right) == 0) ct--;
                }
                fast++;

                while (ct == 0) {
                    if (fast - slow == p.length()) result.add(slow);

                    char left = s.charAt(slow);
                    if (map.containsKey(left)) {
                        map.put(left, map.get(left) + 1);
                        if (map.get(left) > 0) ct++;
                    }
                    slow++;
                }
            }
            return result;
        }

        public static void main(String[] args) {
            System.out.println(findAnagrams("abcbac", "ab"));

    }
}
