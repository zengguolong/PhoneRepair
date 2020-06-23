package com.project.dragon.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        new Main().xorOperation(5,0);
    }

    public static void t(int a) {
        System.out.println(a);
    }

    public int mySqrt(int x) {
        int t = 1;
        while ((long) t * t <= x)
            t++;
        if (t * t == x)
            return t;
        return t - 1;
    }

    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int l = 0, r = -1, ans = 0, n = s.length();
        while (l < n) {
            if (r + 1 < n && freq[s.charAt(r + 1)] == 0) {
                r++;
                freq[s.charAt(r)]++;
            } else {
                freq[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public String longestCommonPrefix(String[] strs) {
        String res = "";
        for (int i = 0; i < strs.length - 1; i++) {

        }
        return res;
    }

    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        int index = 0;
        while (index<n) {
            arr[index] = start + (2 * index);
            index++;
        }
        int res = arr[0];
        for (int i = 1 ; i < arr.length; i++)
            res ^= arr[i];
        return res;
    }
}
