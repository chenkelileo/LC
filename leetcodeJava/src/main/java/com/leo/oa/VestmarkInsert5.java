package com.leo.oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VestmarkInsert5 {
    public static String solution_test1(int x) {
        String num;
        List<Integer> list = new ArrayList<>();

        if (x >= 0) {
            num = Integer.toString(x);
            for (int i = 0; i <= num.length(); i++) {
                list.add(Integer.parseInt(num.substring(0, i) + '5' + num.substring(i, num.length())));//not include end index
            }
        } else {
            num = Integer.toString(-1 * x);
            for (int i = 0; i <= num.length(); i++) {
                list.add(-1 * Integer.parseInt(num.substring(0, i) + '5' + num.substring(i, num.length())));//not include end index
            }
        }
        return Collections.max(list).toString();
    }


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
        System.out.println(solution_test1(9));
        System.out.println(solution_test1(0));
        System.out.println(solution_test1(289));
        System.out.println(solution_test1(259));
        System.out.println(solution_test1(559));
        System.out.println(solution_test1(-999));
        System.out.println(solution_test1(-9));
        System.out.println(solution_test1(-1));
        System.out.println(solution_test1(-292));


//        System.out.println("0".substring(0, 1));
//        System.out.println("0".substring(1, 1));
//        System.out.println(Integer.parseInt("05"));
        //+ '5' +
        //str.substring(i, str.length()))
        //test

    }
}
