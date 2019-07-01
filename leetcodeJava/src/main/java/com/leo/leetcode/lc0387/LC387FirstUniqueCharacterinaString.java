package com.leo.leetcode.lc0387;

import java.util.HashMap;
import java.util.HashSet;

public class LC387FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {//use boolean array
        int[] alp = new int[26];//must to sore all elements first for some case arreeea.
        for(char c : s.toCharArray()){
            alp[c - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(alp[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
    // t: O(n)
    // s：O(n)
    public int firstUniqChar2(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();// key: char, value: how many
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
    // t: O(n)
    // s：O(1)

    public static void main(String[] args) {

    }
}
