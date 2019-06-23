package com.leo.leetcode.lc0245;

public class LC245ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2) && i != j) {
                        min = Math.min(Math.abs(i - j), min);
                    }
                }
            }
        }
        return min;
    }

    public int shortestWordDistance2(String[] words, String word1, String word2) {
        if (words == null || words.length < 2)
            return 0;
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                index1 = i;
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    index1 = index2; //"a", "a" then index1 =index2 ,then let index1 = previous
                }
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        return min;
    }
    public int shortestWordDistance3(String[] words, String word1, String word2) {
        if (words == null || words.length < 2)
            return 0;
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (word1.equals(word2)) {
                    index2 = index1; //"a", "a" then index1 =index2 ,then let index2 = previous
                }
                index1 = i;

            }
            else if (words[i].equals(word2)) {// won't go here
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        return min;
    }



    public static void main(String[] args) {

    }
}
