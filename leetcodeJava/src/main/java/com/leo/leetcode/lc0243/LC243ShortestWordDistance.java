/**
 * 243. Shortest Word Distance
 * Easy
 * <p>
 * 266
 * <p>
 * 27
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
package com.leo.leetcode.lc0243;

public class LC243ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2))
                        min = Math.min(Math.abs(i - j), min);
                }
            }
        }
        return min;
    }
    //t: O(n^2)
    //s: O(1)

    public int shortestDistance2(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                index1 = i;
            else if (words[i].equals(word2))
                index2 = i;
            if (index1 != -1 && index2 != -1)
                min = Math.min(min, Math.abs(index2 - index1));
        }
        return min;
    }
    //t: O(n)
    //s: O(1)

    public static void main(String[] args) {

    }
}

