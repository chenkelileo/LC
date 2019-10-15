package com.leo.amazon;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {
    public static String[] reorder(String[] logs) {
        Comparator<String> logsComp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int posStr1 = str1.indexOf(' ');
                int posStr2 = str2.indexOf(' ');
                char ch1 = str1.charAt(posStr1 + 1);
                char ch2 = str2.charAt(posStr2 + 1);

                if (ch1 <= '9' && ch1 >= '0') {
                    if (ch2 <= '9' && ch2 >= '0') {
                        return 0;
                    } else {
                        return 1;
                    }
                }

                if (ch2 <= '9' && ch2 >= '0') {
                    return -1;
                }


                int strCompRes = str1.substring(posStr1 + 1).compareTo(str2.substring(posStr2 + 1));
                if (strCompRes == 0) {
                    strCompRes = str1.compareTo(str2);
                }
                return strCompRes;
            }
        };
        Arrays.sort(logs, logsComp);
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
        reorder(logs);
    }
}
