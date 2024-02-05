package com.leetcode._14;

public class Solution {
    
String commonPrefix(final String s1, final String s2) {
    int len = Math.min(s1.length(), s2.length());
    for(int i = 0; i < len; i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
            return s1.substring(0, i);
        }
    }

    return s1.substring(0, len);
}


public String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) {
        return strs[0];
    }

    String prefix = strs[0];

    for(int i = 0; i < strs.length; i++) {
        prefix = commonPrefix(prefix, strs[i]);
    }

    return prefix;
}

}
