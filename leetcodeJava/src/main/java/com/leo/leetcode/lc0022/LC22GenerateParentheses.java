package com.leo.leetcode.lc0022;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0)
            return res;
        helper(res, "", n, n);
        return res;
    }

    private void helper(List<String> res, String s, int left, int right) {
        if (left > right)
            return;
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0)
            helper(res, s + "(", left - 1, right);
        if (right > 0)
            helper(res, s + ")", left,right - 1);
    }


































    public List<String> generateParenthesis_test(int n) {
        //corner case
        if(n == 0) {
            return null;
        }

        //init
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        //call function
        dfs(list,sb,n,n);

        //return
        return list;

    }
    private void dfs(List<String> list, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(sb.toString());
        }
        if(left > 0) {
            dfs(list,sb.append('('),left - 1, right);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right > left){
            dfs(list,sb.append(")"),left, right - 1);
            sb.deleteCharAt(sb.length() -1);
        }

    }
}
