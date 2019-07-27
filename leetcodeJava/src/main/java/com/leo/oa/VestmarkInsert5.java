package com.leo.oa;

import java.util.ArrayList;
import java.util.Collections;

public class VestmarkInsert5 {
    public static int solution(int x) {
        ArrayList<Integer> list = new ArrayList<>();
        if (x >= 0) {
            String str = Integer.toString(x);
            for (int i = 0; i <= str.length(); i++) {//keep in mind equal sign here
                list.add(Integer.parseInt(str.substring(0, i) + '5' +
                        str.substring(i, str.length())));
            }
            //list.add(Integer.parseInt(str + '5'));
        } else {
            x = -x;
            String str = Integer.toString(x);
            for (int i = 0; i <= str.length(); i++) {
                list.add(-1 * Integer.parseInt(str.substring(0, i) + '5' +
                        str.substring(i, str.length())));

            }
            //list.add(-1*Integer.parseInt(str + '5'));
        }
        return Collections.max(list);
    }

    public static int solution2(int x) {
        if (x >= 0) {
            String str = Integer.toString(x);
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) <= '5') {
                    return Integer.parseInt(str.substring(0, i) + '5' + str.substring(i, str.length()));
                }
            }
            return Integer.parseInt(str.substring(0, str.length()) + '5');
        } else {
            String str = Integer.toString(-1 * x);
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) >= '5') {
                    return -1 * Integer.parseInt(str.substring(0, i) + '5' + str.substring(i, str.length()));
                }
            }
            return -1 * Integer.parseInt(str.substring(0, str.length()) + '5');
        }
    }

    public static void main(String[] args) {
        //System.out.println(solution2(9));
        //System.out.println(solution2(0));
        //System.out.println(solution2(289));
        //System.out.println(solution2(259));
        //System.out.println(solution2(559));
        //System.out.println(solution2(-999));
        System.out.println(solution2(-9));
        System.out.println(solution2(-1));
        System.out.println(solution2(-292));



        System.out.println("0".substring(0, 0));
        System.out.println("0".substring(1, 1));
        System.out.println(Integer.parseInt("05"));
        //+ '5' +
        //str.substring(i, str.length()))
        //test

    }
}
