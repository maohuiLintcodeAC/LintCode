package leetcode_005;

/**
 * Created by lenovo on 2018/5/3.
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        if (s == null || s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            int start = i;

            // 判断是否有连续的 字符“aaaabbbb”
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    // 回退到字符相同的位置
                    i = j - 1;
                    break;
                }

                i = j;
            }

            int end = i;

            while (start >= 0 && end < s.length()) {
                if (s.charAt(start) != s.charAt(end)) {
                    break;
                }

                start -= 1;
                end += 1;
            }

            // 将上一轮的增量回执
            start += 1;
            end -= 1;

            String tmp = s.substring(start, end + 1);
            if (result.length() < tmp.length()) {
                result = tmp;
//                System.out.println("result: " + tmp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new Solution().longestPalindrome("cbbd");
    }
}